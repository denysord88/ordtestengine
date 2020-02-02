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

public class TestStepAttachment {
    private ObjectId id;
    private String fileName;
    private String fileDescription;
    private String serverFilePath;


    public TestStepAttachment() {
    }

    public TestStepAttachment(final String fileName, final String fileDescription, final String serverFilePath) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.serverFilePath = serverFilePath;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getServerFilePath() {
        return serverFilePath;
    }

    public void setServerFilePath(String serverFilePath) {
        this.serverFilePath = serverFilePath;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestStepAttachment testStepAttachment = (TestStepAttachment) o;

        if (getId() != null ? !getId().equals(testStepAttachment.getId()) : testStepAttachment.getId() != null) {
            return false;
        }
        if (getFileName() != null ? !getFileName().equals(testStepAttachment.getFileName()) : testStepAttachment.getFileName() != null) {
            return false;
        }
        if (getFileDescription() != null ? !getFileDescription().equals(testStepAttachment.getFileDescription()) : testStepAttachment.getFileDescription() != null) {
            return false;
        }
        if (getServerFilePath() != null ? !getServerFilePath().equals(testStepAttachment.getServerFilePath()) : testStepAttachment.getServerFilePath() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        result = 31 * result + (getFileDescription() != null ? getFileDescription().hashCode() : 0);
        result = 31 * result + (getServerFilePath() != null ? getServerFilePath().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestStepAttachment {"
                + "id='" + id + "',"
                + "fileName='" + fileName + "',"
                + "fileDescription='" + fileDescription + "',"
                + "serverFilePath='" + serverFilePath + "'"
                + "}";
    }
}
