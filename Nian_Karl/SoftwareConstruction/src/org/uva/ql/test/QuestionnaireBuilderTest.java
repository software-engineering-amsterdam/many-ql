package org.uva.ql.test;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import org.uva.ql.antlr.QLImplErrorListener;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.questionnaire.Questionnaire;

public class QuestionnaireBuilderTest {

	@Before
	public void setUp() throws Exception { 
	}

	@Test
	public void test() { 
	}

}
