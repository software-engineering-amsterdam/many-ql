package org.nlamah.QL;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Form;

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
    	suite.addTestSuite(QLFormErrorTest.class);
    	
        return suite;
    }
    
    protected static Expression produceExpressionFromString(String string)
	{
		ANTLRInputStream input = new ANTLRInputStream(string);
		
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.expression();
		
		System.out.println(tree.toStringTree(parser));
		
		Expression expression = (Expression)tree.accept(new RawFormTreeBuilder());
		
		return  expression;
	}
    
    protected static Form produceFormFromSourceFile(String folder, String filename)
	{
		ANTLRInputStream input = null;
		
		try 
		{
			InputStream inputStream = QLInterpreter.class.getResourceAsStream("test/" + folder + "/" + filename + ".ql");
			String qlSourceCode = IOUtils.toString(inputStream, "UTF-8");
			input = new ANTLRInputStream(qlSourceCode);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.form();
		
		System.out.println(tree.toStringTree(parser));
		
		Form parsedForm = (Form)tree.accept(new RawFormTreeBuilder());
		
		return  parsedForm;
	}
}
