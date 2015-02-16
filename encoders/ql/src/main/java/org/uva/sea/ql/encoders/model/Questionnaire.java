package org.uva.sea.ql.encoders.model;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Questionnaire containing {@link Question}s.
 * 
 * @author Pim Tegelaar
 */
public class Questionnaire {

	private String name;

	/** Questions, mapped by their name. */
	private SortedMap<String, Question> questions = new TreeMap<String, Question>();

	public SortedMap<String, Question> getQuestions() {
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
