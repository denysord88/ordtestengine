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
package pojo;

import java.util.LinkedList;
import java.util.List;

public class TestSuite {
  private Long id;
  private String title;
  private List<TestCase> testCases = new LinkedList<>();
  private User author;

  public TestSuite(
      Long aId,
      String aTitle,
      List<TestCase> aTestCases,
      User aAuthor
  ) {
    this.id = aId;
    this.title = aTitle;
    this.testCases.addAll(aTestCases);
    this.author = aAuthor;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String aTitle) {
    if (aTitle == null || aTitle.isEmpty()) return;
    this.title = aTitle;
  }

  public void addTestCase(TestCase aTestCase) {
    if(testCases.contains(aTestCase)) return;
    testCases.add(aTestCase);
  }

  public User getAuthor() {
    return author;
  }
}
