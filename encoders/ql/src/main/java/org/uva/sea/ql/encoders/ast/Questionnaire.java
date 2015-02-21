package org.uva.sea.ql.encoders.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Questionnaire containing {@link Question}s.
 */
public class Questionnaire {

	private String name;

	private List<Question> questions = new ArrayList<Question>();

	public List<Question> getQuestions() {
		return questions;
	}

	public Question getQuestion(String name) {
		for (Question question : questions) {
			if (question.getName().equals(name)) {
				return question;
			}
		}
		throw new IllegalStateException(
				"Questionnaire does not contain question with name " + name);
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
