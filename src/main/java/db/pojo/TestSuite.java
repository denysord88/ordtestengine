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

public class TestSuite {
    private ObjectId id;
    private String title;
    private List<TestScenario> testScenarios = new LinkedList<>();

    public TestSuite() {
    }

    public TestSuite(String title, List<TestScenario> testScenarios) {
        this.title = title;
        this.testScenarios.addAll(testScenarios);
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

    public List<TestScenario> getTestScenarios() {
        return testScenarios;
    }

    public void setTestScenarios(List<TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestSuite testSuite = (TestSuite) o;

        if (getId() != null ? !getId().equals(testSuite.getId()) : testSuite.getId() != null) {
            return false;
        }
        if (getTitle() != null ? !getTitle().equals(testSuite.getTitle()) : testSuite.getTitle() != null) {
            return false;
        }
        if (getTestScenarios() != null ? !getTestScenarios().equals(testSuite.getTestScenarios()) : testSuite.getTestScenarios() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getTestScenarios() != null ? getTestScenarios().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestSuite {"
                + "id='" + id + "',"
                + "title='" + title + "',"
                + "testScenarios='" + testScenarios + "'"
                + "}";
    }
}
