package org.nlamah.QBase;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.Builders.FormFactory;
import org.nlamah.QBase.Constants.Language;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Tools.SourceCodeTools;
import org.nlamah.QL.QLLexer;
import org.nlamah.QL.QLParser;
import org.nlamah.QL.Builders.RawFormBuilder;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.StylesheetFactory;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

import junit.framework.TestCase;

public abstract class QBaseTestCase extends TestCase 
{
	protected Form parsedForm;
	protected Form referenceForm;
	
	protected Stylesheet parsedStylesheet;
	protected Stylesheet referenceStylesheet;
	
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

	protected static Form produceFormFromSourceFile(String folder, String fileName, boolean typeChecked) throws QBaseException
	{		
		Form form = new FormFactory(Language.QL).form(SourceCodeTools.qlUriTestForFolderAndFileName(folder, fileName), typeChecked);

		return  form;
	}

	protected static Stylesheet produceStylesheetFromSourceFileWithForm(String folder, String fileName, Form form) throws QBaseException
	{			
		Stylesheet stylesheet = new StylesheetFactory().stylesheet(SourceCodeTools.qlsUriTestForFolderAndFileName(folder, fileName), form);
		
		return stylesheet;	
	}
}
