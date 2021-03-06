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

public class TestStep {
    private ObjectId id;
    private String step;
    private String result;
    private List<ObjectId> attachments = new LinkedList<>();

    public TestStep() {
    }

    public TestStep(final String step, final String result, final List<ObjectId> attachments) {
        this.step = step;
        this.result = result;
        this.attachments.addAll(attachments);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ObjectId> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ObjectId> attachments) {
        this.attachments = attachments;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestStep testStep = (TestStep) o;

        if (getId() != null ? !getId().equals(testStep.getId()) : testStep.getId() != null) {
            return false;
        }
        if (getStep() != null ? !getStep().equals(testStep.getStep()) : testStep.getStep() != null) {
            return false;
        }
        if (getResult() != null ? !getResult().equals(testStep.getResult()) : testStep.getResult() != null) {
            return false;
        }
        if (getAttachments() != null ? !getAttachments().equals(testStep.getAttachments()) : testStep.getAttachments() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getStep() != null ? getStep().hashCode() : 0);
        result = 31 * result + (getResult() != null ? getResult().hashCode() : 0);
        result = 31 * result + (getAttachments() != null ? getAttachments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestStep {"
                + "id='" + id + "',"
                + "step='" + step + "',"
                + "result='" + result + "',"
                + "authorId='" + attachments + "'"
                + "}";
    }
}
