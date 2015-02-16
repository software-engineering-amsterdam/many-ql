package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.encoders.QL2Lexer;
import org.uva.sea.ql.encoders.QL2Parser;
import org.uva.sea.ql.encoders.model.Questionnaire;

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
		QL2Lexer lexer = new QL2Lexer(new ANTLRFileStream(location));
		QL2Parser parser = new QL2Parser(new CommonTokenStream(lexer));

		QuestionnaireListener questionnaireListener = new QuestionnaireListener();
		parser.addParseListener(questionnaireListener);
		parser.form();

		Questionnaire questionnaire = questionnaireListener.getQuestionnaire();
		return questionnaire;
	}

}
