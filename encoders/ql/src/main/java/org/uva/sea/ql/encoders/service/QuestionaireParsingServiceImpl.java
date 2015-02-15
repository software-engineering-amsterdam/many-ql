package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.encoders.QL2Lexer;
import org.uva.sea.ql.encoders.QL2Parser;
import org.uva.sea.ql.encoders.model.Questionaire;

/**
 * Implementation for {@link QuestionaireParsingService}.
 * 
 * @author Pim Tegelaar
 */
public class QuestionaireParsingServiceImpl implements
		QuestionaireParsingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Questionaire parse(String location) throws IOException {
		QL2Lexer lexer = new QL2Lexer(new ANTLRFileStream(location));
		QL2Parser parser = new QL2Parser(new CommonTokenStream(lexer));

		QuestionaireListener questionaireListener = new QuestionaireListener();
		parser.addParseListener(questionaireListener);
		parser.form();

		Questionaire questionaire = questionaireListener.getQuestionaire();
		return questionaire;
	}

}
