package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.encoders.EncodersQLLexer;
import org.uva.sea.ql.encoders.EncodersQLParser;
import org.uva.sea.ql.encoders.ast.Questionnaire;

/**
 * Implementation for {@link QuestionnaireParsingService}.
 * 
 * @author Pim Tegelaar
 */
public class QuestionnaireParsingServiceImpl implements
		QuestionnaireParsingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Questionnaire parse(String location) throws IOException {
		EncodersQLLexer lexer = new EncodersQLLexer(new ANTLRFileStream(
				location));
		EncodersQLParser parser = new EncodersQLParser(new CommonTokenStream(
				lexer));

		QuestionnaireListener questionnaireListener = new QuestionnaireListener();
		parser.addParseListener(questionnaireListener);
		parser.questionnaire();

		Questionnaire questionnaire = questionnaireListener.getQuestionnaire();
		return questionnaire;
	}

}
