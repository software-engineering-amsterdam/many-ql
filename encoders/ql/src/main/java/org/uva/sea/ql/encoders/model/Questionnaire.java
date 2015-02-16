package org.uva.sea.ql.encoders.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Questionnaire containing {@link Question}s.
 * 
 * @author Pim Tegelaar
 */
public class Questionnaire {

	private String name;

	/** Questions, mapped by their name. */
	private TreeMap<String, Question> questions = new TreeMap<String, Question>();

	public Map<String, Question> getQuestions() {
		return questions;
	}

	public Question getQuestion(String name) {
		return questions.get(name);
	}

	public void addQuestion(Question question) {
		questions.put(question.getName(), question);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
