/*
 * Copyright 2011 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package my.test.cql3.statements;

import my.test.TestBase;

public class TypeTest extends TestBase {

    public static void main(String[] args) throws Exception {
        new TypeTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        dropTest();
        createTest();
        alterTest();
    }

    void createTest() throws Exception {
        execute("CREATE TYPE IF NOT EXISTS TypeTest(myint int, mytext text)");
    }

    void alterTest() throws Exception {
        tryExecute("ALTER TYPE TypeTest ALTER myint TYPE boolean");
        execute("ALTER TYPE TypeTest ADD myfloat float");
        execute("ALTER TYPE TypeTest RENAME myint TO mybigint AND myfloat TO myf");
    }

    void dropTest() throws Exception {
        execute("DROP TYPE IF EXISTS TypeTest");
    }

}
