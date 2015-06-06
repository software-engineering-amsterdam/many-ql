package org.nlamah.QLS;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.FileReadException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.QLTest;
import org.nlamah.QLS.Builders.RawStylesheetBuilder;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QLSTest extends QLTest
{
	public static Test suite()
	{
		final TestSuite suite = new TestSuite("QLSTestSuite");

		suite.addTestSuite(QLStylesheetTest.class);
		suite.addTestSuite(QLStylesheetErrorTest.class);
		suite.addTestSuite(QLStyleCombiningTest.class);

		return suite;
	}

	protected static ParseTree produceParseTreeFromSourceFile(String folder, String fileName)
	{
		try 
		{
			String qlSourceCode = QBaseHelper.qlsSourceCodeTestForFolderAndFileName(folder, fileName);

			ANTLRInputStream input = new ANTLRInputStream(qlSourceCode);

			QLSLexer lexer = new QLSLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			QLSParser parser = new QLSParser(tokens);
			
			return  parser.stylesheet();
		} 
		catch (FileReadException e) 
		{
			assertTrue(false);
		}

		return null;
	}

	protected static Stylesheet produceStylesheetFromSourceFileWithoutForm(String folder, String filename)
	{				
		ParseTree tree = produceParseTreeFromSourceFile(folder, filename);

		RawStylesheetBuilder stylesheetBuilder = new RawStylesheetBuilder();

		Stylesheet parsedStylesheet = stylesheetBuilder.build(tree);
		
		return parsedStylesheet;	
	}
}