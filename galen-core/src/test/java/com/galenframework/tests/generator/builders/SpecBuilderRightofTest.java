/*******************************************************************************
* Copyright 2017 Ivan Shubin http://galenframework.com
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
package com.galenframework.tests.generator.builders;

import com.galenframework.generator.*;
import com.galenframework.generator.builders.SpecBuilderRightOf;
import com.galenframework.generator.builders.SpecGeneratorOptions;
import com.galenframework.generator.raycast.EdgesContainer;
import com.galenframework.page.Point;
import com.galenframework.page.Rect;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpecBuilderRightofTest {

    @Test
    public void should_generate_spec_rightof() {
        SpecBuilderRightOf specBuilderRightOf = new SpecBuilderRightOf(
            new PageItem("icon", new Rect(100, 10, 50, 50)),
            new EdgesContainer.Edge(new PageItemNode(new PageItem("caption")), new Point(70, 10), new Point(70, 50))
        );

        List<SpecStatement> specStatements = specBuilderRightOf.buildSpecs(new LinkedList<>(), new SpecGeneratorOptions());

        assertThat(specStatements.size(), is(1));
        SpecStatement statement = specStatements.get(0);
        assertThat(statement.getStatement(), is("right-of caption 30px"));

        assertThat(statement.getAssertions().size(), is(1));
        assertThat(statement.getAssertions().get(0), is(new SpecAssertion(
            new AssertionEdge("icon", AssertionEdge.EdgeType.left),
            new AssertionEdge("caption", AssertionEdge.EdgeType.right))));
    }
}
