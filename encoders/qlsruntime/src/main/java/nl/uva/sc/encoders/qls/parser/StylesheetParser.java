package nl.uva.sc.encoders.qls.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.qls.EncodersQLSLexer;
import nl.uva.sc.encoders.qls.EncodersQLSParser;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylesheetContext;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.ast.TextLocation;
import nl.uva.sc.encoders.qls.ast.builder.AstBuilder;
import nl.uva.sc.encoders.qls.validation.SyntaxError;

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

		AstBuilder astBuilder = new AstBuilder();
		Stylesheet stylesheet = (Stylesheet) astBuilder.visit(parseTree);

		return new StylesheetParsingResult(stylesheet, syntaxErrors);
	}

}
