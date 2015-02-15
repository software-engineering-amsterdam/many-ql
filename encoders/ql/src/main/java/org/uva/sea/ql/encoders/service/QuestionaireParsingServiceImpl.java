package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.model.Question;
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
	public Questionaire parse(String location) {
		// TODO replace this dummy implementation with an actual implementation
		Questionaire questionaire = new Questionaire();
		Question question = new Question();
		question.setName("hasSoldHouse");
		questionaire.addQuestion(question);
		return questionaire;
	}

}
