package org.nlamah.QL;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.FormFactory;
import org.nlamah.QBase.Language;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.Error.QBaseException;
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

		suite.addTestSuite(QLFormTest.class);
		suite.addTestSuite(QLComputationalExpressionTest.class);
		suite.addTestSuite(QLLogicalExpressionTest.class);
		suite.addTestSuite(QLFormErrorTest.class);
		suite.addTestSuite(QLFragmentiserTest.class);

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

	public static Form produceFormFromSourceFile(String folder, String fileName, boolean typechecked) throws QBaseException
	{		
		Form form = new FormFactory(Language.QL).form(QBaseHelper.qlUriTestForFolderAndFileName(folder, fileName), typechecked);

		return  form;
	}
}