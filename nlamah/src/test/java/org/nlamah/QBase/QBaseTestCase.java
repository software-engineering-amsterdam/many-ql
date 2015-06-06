package org.nlamah.QBase;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.FileReadException;
import org.nlamah.QBase.FormFactory;
import org.nlamah.QBase.Language;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.QLLexer;
import org.nlamah.QL.QLParser;
import org.nlamah.QL.Builders.RawFormBuilder;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.QLSLexer;
import org.nlamah.QLS.QLSParser;
import org.nlamah.QLS.Builders.RawStylesheetBuilder;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

import junit.framework.TestCase;

public abstract class QBaseTestCase extends TestCase 
{
	protected Form parsedForm;
	protected Form referenceForm;
	
	protected static Expression produceQLExpressionFromString(String string)
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

	protected static Form produceFormFromSourceFile(String folder, String fileName, boolean typechecked) throws QBaseException
	{		
		Form form = new FormFactory(Language.QL).form(QBaseHelper.qlUriTestForFolderAndFileName(folder, fileName), typechecked);

		return  form;
	}
	
	protected static ParseTree produceQLSParseTreeFromSourceFile(String folder, String fileName)
	{
		try 
		{
			String qlsSourceCode = QBaseHelper.qlsSourceCodeTestForFolderAndFileName(folder, fileName);

			ANTLRInputStream input = new ANTLRInputStream(qlsSourceCode);

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
		ParseTree tree = produceQLSParseTreeFromSourceFile(folder, filename);

		RawStylesheetBuilder stylesheetBuilder = new RawStylesheetBuilder();

		Stylesheet parsedStylesheet = stylesheetBuilder.build(tree);
		
		return parsedStylesheet;	
	}
}
