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

public class TestRun {
    private ObjectId id;
    private String title;
    private ObjectId testSuiteId;
    private List<ObjectId> testScenarioRuns = new LinkedList<>();

    public TestRun() {
    }

    public TestRun(final String title, ObjectId testSuiteId, final List<ObjectId> testScenarioRuns) {
        this.title = title;
        this.testSuiteId = testSuiteId;
        this.testScenarioRuns.addAll(testScenarioRuns);
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

    public ObjectId getTestSuiteId() {
        return testSuiteId;
    }

    public void setTestSuiteId(ObjectId testSuiteId) {
        this.testSuiteId = testSuiteId;
    }

    public List<ObjectId> getTestScenarioRuns() {
        return testScenarioRuns;
    }

    public void setTestScenarioRuns(List<ObjectId> testScenarioRuns) {
        this.testScenarioRuns = testScenarioRuns;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestRun testRun = (TestRun) o;

        if (getId() != null ? !getId().equals(testRun.getId()) : testRun.getId() != null) {
            return false;
        }
        if (getTitle() != null ? !getTitle().equals(testRun.getTitle()) : testRun.getTitle() != null) {
            return false;
        }
        if (getTestSuiteId() != null ? !getTestSuiteId().equals(testRun.getTestSuiteId()) : testRun.getTestSuiteId() != null) {
            return false;
        }
        if (getTestScenarioRuns() != null ? !getTestScenarioRuns().equals(testRun.getTestScenarioRuns()) : testRun.getTestScenarioRuns() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getTestSuiteId() != null ? getTestSuiteId().hashCode() : 0);
        result = 31 * result + (getTestScenarioRuns() != null ? getTestScenarioRuns().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestRun {"
                + "id='" + id + "',"
                + "title='" + title + "',"
                + "testSuiteId='" + testSuiteId + "',"
                + "testScenarioRuns='" + testScenarioRuns + "'"
                + "}";
    }
}
