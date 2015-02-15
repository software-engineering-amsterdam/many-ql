package org.uva.sea.ql.encoders;

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
		questionaire.addQuestion(question);
		return questionaire;
	}

}
