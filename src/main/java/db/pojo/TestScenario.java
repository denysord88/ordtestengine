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
package db.pojo;

import org.bson.types.ObjectId;

import java.util.LinkedList;
import java.util.List;

public class TestScenario {
    private ObjectId id;
    private String title;
    private String description;
    private List<ObjectId> testSteps = new LinkedList<>();

    public TestScenario() {
    }

    public TestScenario(final String title, final String description, final List<ObjectId> testSteps) {
        this.title = title;
        this.description = description;
        this.testSteps.addAll(testSteps);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ObjectId> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(List<ObjectId> testSteps) {
        this.testSteps = testSteps;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestScenario testScenario = (TestScenario) o;

        if (getId() != null ? !getId().equals(testScenario.getId()) : testScenario.getId() != null) {
            return false;
        }
        if (getTitle() != null ? !getTitle().equals(testScenario.getTitle()) : testScenario.getTitle() != null) {
            return false;
        }
        if (getDescription() != null ? !getDescription().equals(testScenario.getDescription()) : testScenario.getDescription() != null) {
            return false;
        }
        if (getTestSteps() != null ? !getTestSteps().equals(testScenario.getTestSteps()) : testScenario.getTestSteps() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getTestSteps() != null ? getTestSteps().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestScenario {"
                + "id='" + id + "',"
                + "title='" + title + "',"
                + "description='" + description + "',"
                + "testSteps='" + testSteps + "'"
                + "}";
    }
}
