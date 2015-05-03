package org.nlamah.QL;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.FileReadException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Builders.RawFormBuilder;
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

		//suite.addTestSuite(QLFormTest.class);
	//	suite.addTestSuite(QLComputationalExpressionTest.class);
		//suite.addTestSuite(QLLogicalExpressionTest.class);
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
		RawFormBuilder formBuilder = new RawFormBuilder();
		Expression expression = (Expression)formBuilder.visit(tree);

		return  expression;
	}

	protected static Form produceFormFromSourceFile(String folder, String filename)
	{		
		try 
		{
			String qlSourceCode = QBaseHelper.getSourceCode(System.getProperty("user.dir") + "/target/classes/org/nlamah/QBase/QL/test/" + folder + "/" + filename + ".ql");
			
			ANTLRInputStream input = new ANTLRInputStream(qlSourceCode);

			QLLexer lexer = new QLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			QLParser parser = new QLParser(tokens);
			ParseTree tree = parser.form();
			RawFormBuilder formBuilder = new RawFormBuilder();
			Form parsedForm = formBuilder.buildForm(tree);

			return  parsedForm;
		} 
		catch (FileReadException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return null;
	}
}
