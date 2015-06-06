package org.nlamah.QBase.Tools;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QL.QLLexer;
import org.nlamah.QL.QLParser;
import org.nlamah.QL.Builders.RawFormBuilder;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QLS.QLSLexer;
import org.nlamah.QLS.QLSParser;

public class AntlrTools 
{
	static public QLParser createQLParserWithSourceCode(String sourceCode)
	{
		ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLLexer lexer = new QLLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		return new QLParser(tokens);
	}
	
	static public ParseTree createFormTreeFromSourceCode(String sourceCode, ANTLRErrorListener listener)
	{
		QLParser parser = createQLParserWithSourceCode(sourceCode);

		parser.addErrorListener(listener);

		return parser.form();
	}
	
	static public Expression createQLExpressionFromString(String sourceCode)
	{
		QLParser parser = createQLParserWithSourceCode(sourceCode);
		
		ParseTree tree = parser.expression();
		
		RawFormBuilder formBuilder = new RawFormBuilder();
		Expression expression = (Expression)formBuilder.visit(tree);

		return  expression;
	}
	
	static public ParseTree createStylesheetTreeFromSourceCode(String sourceCode, ANTLRErrorListener listener)
	{
		ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLSLexer lexer = new QLSLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		QLSParser parser = new QLSParser(tokens);

		parser.addErrorListener(listener);

		return parser.stylesheet();
	}
}
