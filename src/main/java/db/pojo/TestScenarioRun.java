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

public class TestScenarioRun {
    public enum Status {
        PLANNED,
        ASSIGNED,
        IN_PROGRESS,
        FAILED,
        BLOCKED,
        SKIPPED,
        RETEST
    }

    private ObjectId id;
    private ObjectId testScenarioId;
    private ObjectId userId;
    private Status status;
    private List<ObjectId> testStepRunComments = new LinkedList<>();

    public TestScenarioRun() {
    }

    public TestScenarioRun(final ObjectId testScenarioId, final ObjectId userId, final Status status, final List<ObjectId> testStepRunComments) {
        this.testScenarioId = testScenarioId;
        this.userId = userId;
        this.status = status;
        this.testStepRunComments.addAll(testStepRunComments);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getTestScenarioId() {
        return testScenarioId;
    }

    public void setTestScenarioId(ObjectId testScenarioId) {
        this.testScenarioId = testScenarioId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ObjectId> getTestStepRunComments() {
        return testStepRunComments;
    }

    public void setTestStepRunComments(List<ObjectId> testStepRunComments) {
        this.testStepRunComments = testStepRunComments;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestScenarioRun testScenarioRun = (TestScenarioRun) o;

        if (getId() != null ? !getId().equals(testScenarioRun.getId()) : testScenarioRun.getId() != null) {
            return false;
        }
        if (getTestScenarioId() != null ? !getTestScenarioId().equals(testScenarioRun.getTestScenarioId()) : testScenarioRun.getTestScenarioId() != null) {
            return false;
        }
        if (getUserId() != null ? !getUserId().equals(testScenarioRun.getUserId()) : testScenarioRun.getUserId() != null) {
            return false;
        }
        if (getStatus() != null ? !getStatus().equals(testScenarioRun.getStatus()) : testScenarioRun.getStatus() != null) {
            return false;
        }
        if (getTestStepRunComments() != null ? !getTestStepRunComments().equals(testScenarioRun.getTestStepRunComments()) : testScenarioRun.getTestStepRunComments() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTestScenarioId() != null ? getTestScenarioId().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getTestStepRunComments() != null ? getTestStepRunComments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestScenarioRun {"
                + "id='" + id + "',"
                + "testScenarioId='" + testScenarioId + "',"
                + "userId='" + userId + "',"
                + "status='" + status + "',"
                + "testStepRunComments='" + testStepRunComments + "'"
                + "}";
    }
}
