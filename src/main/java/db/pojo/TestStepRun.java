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

public class TestStepRun {
    public enum Type {
        INFO,
        RFC,
        BUG,
        BLOCKED
    }

    private ObjectId id;
    private Type type;
    private ObjectId testRunId;
    private ObjectId testScenarioId;
    private ObjectId testStepId;
    private String comment;

    public TestStepRun() {
    }

    public TestStepRun(final Type type, final ObjectId testRunId, final ObjectId testScenarioId, final ObjectId testStepId, final String comment) {
        this.type = type;
        this.testRunId = testRunId;
        this.testScenarioId = testScenarioId;
        this.testStepId = testStepId;
        this.comment = comment;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ObjectId getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(ObjectId testRunId) {
        this.testRunId = testRunId;
    }

    public ObjectId getTestScenarioId() {
        return testScenarioId;
    }

    public void setTestScenarioId(ObjectId testScenarioId) {
        this.testScenarioId = testScenarioId;
    }

    public ObjectId getTestStepId() {
        return testStepId;
    }

    public void setTestStepId(ObjectId testStepId) {
        this.testStepId = testStepId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestStepRun testStepRun = (TestStepRun) o;

        if (getId() != null ? !getId().equals(testStepRun.getId()) : testStepRun.getId() != null) {
            return false;
        }
        if (getType() != null ? !getType().equals(testStepRun.getType()) : testStepRun.getType() != null) {
            return false;
        }
        if (getTestRunId() != null ? !getTestRunId().equals(testStepRun.getTestRunId()) : testStepRun.getTestRunId() != null) {
            return false;
        }
        if (getTestScenarioId() != null ? !getTestScenarioId().equals(testStepRun.getTestScenarioId()) : testStepRun.getTestScenarioId() != null) {
            return false;
        }
        if (getTestStepId() != null ? !getTestStepId().equals(testStepRun.getTestStepId()) : testStepRun.getTestStepId() != null) {
            return false;
        }
        if (getComment() != null ? !getComment().equals(testStepRun.getComment()) : testStepRun.getComment() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getTestRunId() != null ? getTestRunId().hashCode() : 0);
        result = 31 * result + (getTestScenarioId() != null ? getTestScenarioId().hashCode() : 0);
        result = 31 * result + (getTestStepId() != null ? getTestStepId().hashCode() : 0);
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestStepRun {"
                + "id='" + id + "',"
                + "type='" + type + "',"
                + "testRunId='" + testRunId + "',"
                + "testScenarioId='" + testScenarioId + "',"
                + "testStepId='" + testStepId + "',"
                + "comment='" + comment + "'"
                + "}";
    }
}
