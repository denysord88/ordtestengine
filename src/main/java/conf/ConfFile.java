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

import java.io.FileInputStream;
import java.util.Properties;

public class ConfFile {
    private static Properties p;

    static {
        try (FileInputStream in = new FileInputStream("conf/init.properties")) {
            p = new Properties();
            p.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String parameterName) {
        String property = System.getProperty(parameterName);
        if (property == null) {
            property = p.getProperty(parameterName);
        }
        return property;
    }

    public static int getInt(String parameterName) {
        return Integer.parseInt(get(parameterName));
    }

    public static boolean getBool(String parameterName) {
        return Boolean.parseBoolean(get(parameterName));
    }
}
