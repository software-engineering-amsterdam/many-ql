package nl.uva.sc.encoders.qlruntime.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.EncodersQLLexer;
import nl.uva.sc.encoders.ql.EncodersQLParser;
import nl.uva.sc.encoders.ql.EncodersQLParser.QuestionnaireContext;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.builder.AstBuilder;
import nl.uva.sc.encoders.ql.validation.SyntaxError;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class QuestionnaireParser {

	public QuestionnaireParsingResult parse(String pathname) throws IOException {
		EncodersQLLexer lexer = new EncodersQLLexer(new ANTLRFileStream(pathname));
		EncodersQLParser parser = new EncodersQLParser(new CommonTokenStream(lexer));

		List<SyntaxError> syntaxErrors = new ArrayList<>();

		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int column, String msg,
					RecognitionException e) {
				syntaxErrors.add(new SyntaxError(msg, new TextLocation(line, column)));
			}
		});

		QuestionnaireContext parseTree = parser.questionnaire();

		AstBuilder astBuilder = new AstBuilder();
		Questionnaire questionnaire = (Questionnaire) astBuilder.visit(parseTree);

		return new QuestionnaireParsingResult(questionnaire, syntaxErrors);
	}

}
