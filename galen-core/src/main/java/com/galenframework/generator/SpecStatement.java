/*******************************************************************************
* Copyright 2018 Ivan Shubin http://galenframework.com
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*   http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
******************************************************************************/
package com.galenframework.generator;


import java.util.List;

public class SpecStatement {
    private String statement;
    private List<SpecAssertion> assertions;


    public SpecStatement(String statement) {
        this.statement = statement;
    }

    public SpecStatement(String statement, List<SpecAssertion> assertions) {
        this.statement = statement;
        this.assertions = assertions;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<SpecAssertion> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<SpecAssertion> assertions) {
        this.assertions = assertions;
    }
}
