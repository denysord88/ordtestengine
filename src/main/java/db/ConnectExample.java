/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import pojo.TestStep;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.DeleteResult;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.not;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;

public class ConnectExample {
  public static void main(String[] args) {
    MongoClient mongoClient;

    if (args.length == 0) {
      // connect to the local database server
      mongoClient = MongoClients.create();
    } else {
      mongoClient = MongoClients.create(args[0]);
    }
    //mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");

    // create codec registry for POJOs
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    // get handle to "mydb" database
    MongoDatabase database = mongoClient.getDatabase("mydb").withCodecRegistry(pojoCodecRegistry);

    // get a handle to the "testStep" collection
    MongoCollection<TestStep> collection = database.getCollection("myTestStep", TestStep.class);

    // drop all the data in it
    collection.drop();

    // make a document and insert it
    TestStep testStep = new TestStep("Open google.com page.", "The google.com page was opened.");
    System.out.println("Original TestStep Model: " + testStep);
    collection.insertOne(testStep);

    // TestStep will now have an ObjectId
    System.out.println("Mutated TestStep Model: " + testStep);

    // get it (since it's the only one in there since we dropped the rest earlier on)
    TestStep myTestStep = collection.find().first();
    System.out.println(myTestStep);

    // now, lets add some more people so we can explore queries and cursors
    List<TestStep> testSteps = asList(
        new TestStep("Open yahoo.com page.", "The yahoo.com page was opened."),
        new TestStep("Open localhost.com page.", "The localhost.com page was opened."),
        new TestStep("Open myhost.com page.", "The myhost.com page was opened.")
    );

    collection.insertMany(testSteps);
    System.out.println("total # of testSteps " + collection.countDocuments());

    System.out.println();
    // lets get all the documents in the collection and print them out
    Block<TestStep> printBlock = System.out::println;

    collection.find().forEach(printBlock);

    System.out.println();
    // now use a query to get 1 document out
    myTestStep = collection.find(eq("step", "Open yahoo.com page.")).first();
    System.out.println(myTestStep);

    System.out.println();
    // now lets find every over 30
    collection.find(gt("id", 2)).forEach(printBlock);

    System.out.println();
    // Update One
    collection.updateOne(eq("result", "The localhost.com page was opened."), combine(set("step", "Open updated localhost.com page."), set("result", "The localhost.com page was not opened.")));

    System.out.println();
    // Update Many
    UpdateResult updateResult = collection.updateMany(not(eq("id", 1)), set("step", "Updated many"));
    System.out.println(updateResult.getModifiedCount());

    System.out.println();
    // Replace One
    updateResult = collection.replaceOne(eq("id", "2"), testStep);
    System.out.println(updateResult.getModifiedCount());

    // Delete One
    collection.deleteOne(eq("id", "1"));

    // Delete Many
    DeleteResult deleteResult = collection.deleteMany(eq("step", "Open yahoo.com page."));
    System.out.println(deleteResult.getDeletedCount());

    // Clean up
    database.drop();

    // release resources
    mongoClient.close();
  }
}
