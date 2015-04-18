package org.nlamah.QL;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Visitors.MyQLVisitor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QLTest extends TestCase
{
    public static Test suite()
    {
    	final TestSuite suite = new TestSuite("QLTestSuite");
    	
    	suite.addTestSuite(QLFormTest.class);
    	suite.addTestSuite(QLComputationalExpressionTest.class);
    	suite.addTestSuite(QLLogicalExpressionTest.class);
    	
        return suite;
    }
    
    public static Expression produceExpressionFromString(String string)
	{
		ANTLRInputStream input = new ANTLRInputStream(string);
		
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.expression();
		
		System.out.println(tree.toStringTree(parser));
		
		Expression expression = (Expression)tree.accept(new MyQLVisitor());
		
		return  expression;
	}
}
