package org.nlamah.QLS;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.FileReadException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Builders.RawStyleSheetBuilder;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QLSTest extends TestCase
{
	public static Test suite()
	{
		final TestSuite suite = new TestSuite("QLSTestSuite");

		suite.addTestSuite(QLStylesheetTest.class);

		return suite;
	}

	protected static QLStylesheet produceStylesheetFromSourceFile(String folder, String filename)
	{		
		try 
		{
			String qlSourceCode = QBaseHelper.getSourceCode("QLS/test/" + folder + "/" + filename + ".qls");
			
			ANTLRInputStream input = new ANTLRInputStream(qlSourceCode);

			QLSLexer lexer = new QLSLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			QLSParser parser = new QLSParser(tokens);
			ParseTree tree = parser.stylesheet();
			RawStyleSheetBuilder stylesheetBuilder = new RawStyleSheetBuilder();
			
			QLStylesheet parsedStylesheet = stylesheetBuilder.build(tree);

			return  parsedStylesheet;
		} 
		catch (FileReadException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (QLSException e)
		{
			// TODO
			e.printStackTrace();
		}

		return null;
	}
}
