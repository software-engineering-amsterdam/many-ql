package org.uva.sea.ql.encoders.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Questionaire containing {@link Question}s.
 * 
 * @author Pim Tegelaar
 */
public class Questionaire {

	/** Questions, mapped by their name. */
	private Map<String, Question> questions = new HashMap<String, Question>();

	public Map<String, Question> getQuestions() {
		return questions;
	}

	public Question getQuestion(String name) {
		return questions.get(name);
	}

	public void addQuestion(Question question) {
		questions.put(question.getName(), question);
	}
}
