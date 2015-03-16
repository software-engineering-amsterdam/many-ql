package nl.uva.sc.encoders.qlruntime.service;

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
import nl.uva.sc.encoders.ql.validation.TypeChecker;
import nl.uva.sc.encoders.ql.validation.TypeValidation;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Implementation for {@link QuestionnaireParsingService}.
 */
public class QuestionnaireParsingServiceImpl implements QuestionnaireParsingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QuestionnaireParsingResult parse(String location) throws IOException {
		EncodersQLLexer lexer = new EncodersQLLexer(new ANTLRFileStream(location));
		EncodersQLParser parser = new EncodersQLParser(new CommonTokenStream(lexer));

		List<SyntaxError> syntaxErrors = new ArrayList<SyntaxError>();

		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int column, String msg,
					RecognitionException e) {
				syntaxErrors.add(new SyntaxError(msg, new TextLocation(line, column)));
			}
		});

		QuestionnaireContext parseTree = parser.questionnaire();

		AstBuilder qlInterpreter = new AstBuilder();
		Questionnaire questionnaire = (Questionnaire) qlInterpreter.visit(parseTree);

		TypeChecker typeChecker = new TypeChecker(questionnaire.getAllQuestions());
		List<TypeValidation> typeValidations = new ArrayList<>();
		typeValidations.addAll(typeChecker.checkTypes());

		return new QuestionnaireParsingResult(questionnaire, syntaxErrors, typeValidations);
	}

}
