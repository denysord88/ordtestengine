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
package conf;

public class Properties {
    // MongoDB connection parameters
    public static final String MONGO_HOST = ConfFile.get("MONGO_HOST");
    public static final String MONGO_PORT = ConfFile.get("MONGO_PORT");
    public static final String MONGO_INITDB_ROOT_USERNAME = ConfFile.get("MONGO_INITDB_ROOT_USERNAME");
    public static final String MONGO_INITDB_ROOT_PASSWORD = ConfFile.get("MONGO_INITDB_ROOT_PASSWORD");

    // Web Server
    public static final int SERVER_PORT = ConfFile.getInt("SERVER_PORT");
    public static final boolean HTTP_FILES_LISTING = ConfFile.getBool("HTTP_FILES_LISTING");
    public static final boolean SERVER_LOGS_IN_CONSOLE = ConfFile.getBool("SERVER_LOGS_IN_CONSOLE");
    public static final boolean SERVER_LOGS_IN_FILE = ConfFile.getBool("SERVER_LOGS_IN_FILE");
    public static final int SERVER_LOGS_BUFFER_BYTES = ConfFile.getInt("SERVER_LOGS_BUFFER_BYTES");
    public static final int SERVER_MAX_CONNECTIONS = ConfFile.getInt("SERVER_MAX_CONNECTIONS");
}
