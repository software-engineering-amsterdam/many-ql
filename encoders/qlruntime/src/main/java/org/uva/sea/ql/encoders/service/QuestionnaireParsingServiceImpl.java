package org.uva.sea.ql.encoders.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.uva.sea.ql.encoders.EncodersQLLexer;
import org.uva.sea.ql.encoders.EncodersQLParser;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.validation.SyntaxError;
import org.uva.sea.ql.encoders.validation.TypeValidation;
import org.uva.sea.ql.encoders.visitor.QuestionnaireVisitor;
import org.uva.sea.ql.encoders.visitor.TypeCheckerVisitor;

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

		QuestionnaireVisitor visitor = new QuestionnaireVisitor();
		Questionnaire questionnaire = (Questionnaire) visitor.visit(parseTree);

		TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(questionnaire.getQuestions());
		List<TypeValidation> typeValidations = new ArrayList<>();
		typeValidations.addAll(typeChecker.checkTypes());

		return new QuestionnaireParsingResult(questionnaire, syntaxErrors, typeValidations);
	}

}
