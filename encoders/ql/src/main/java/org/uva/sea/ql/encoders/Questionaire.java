package org.uva.sea.ql.encoders;

import java.util.ArrayList;
import java.util.List;

/**
 * Questionaire containing {@link Question}s.
 * 
 * @author Pim Tegelaar
 */
public class Questionaire {

	private List<Question> questions = new ArrayList<Question>();

	public List<Question> getQuestions() {
		return questions;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
