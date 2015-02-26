package org.uva.sea.ql.encoders.model;

import java.util.List;

public class UIQuestionnaire {

	private final String name;

	private final List<UIQuestion> questions;

	public UIQuestionnaire(List<UIQuestion> questions, String name) {
		this.questions = questions;
		this.name = name;
	}

	public List<UIQuestion> getQuestions() {
		return questions;
	}

	public String getName() {
		return name;
	}
}
