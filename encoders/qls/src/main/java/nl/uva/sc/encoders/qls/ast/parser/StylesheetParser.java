package nl.uva.sc.encoders.qls.ast.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.validation.SyntaxError;
import nl.uva.sc.encoders.qls.EncodersQLSLexer;
import nl.uva.sc.encoders.qls.EncodersQLSParser;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylesheetContext;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.ast.parser.ParseTreeToAbstractSyntaxTree;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class StylesheetParser {

	public StylesheetParsingResult parse(String pathname) throws IOException {
		EncodersQLSLexer lexer = new EncodersQLSLexer(new ANTLRFileStream(pathname));
		EncodersQLSParser parser = new EncodersQLSParser(new CommonTokenStream(lexer));

		List<SyntaxError> syntaxErrors = new ArrayList<>();

		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int column, String msg,
					RecognitionException e) {
				syntaxErrors.add(new SyntaxError(msg, new TextLocation(line, column)));
			}
		});

		StylesheetContext parseTree = parser.stylesheet();

		ParseTreeToAbstractSyntaxTree parseTreeToAbstractSyntaxTree = new ParseTreeToAbstractSyntaxTree();
		Stylesheet stylesheet = (Stylesheet) parseTreeToAbstractSyntaxTree.visit(parseTree);

		return new StylesheetParsingResult(stylesheet, syntaxErrors);
	}

}
