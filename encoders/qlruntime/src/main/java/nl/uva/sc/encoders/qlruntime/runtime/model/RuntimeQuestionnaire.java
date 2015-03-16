package nl.uva.sc.encoders.qlruntime.runtime.model;

import java.util.List;

public class RuntimeQuestionnaire {

	private final String name;

	private final List<RuntimeQuestion> questions;

	public RuntimeQuestionnaire(List<RuntimeQuestion> questions, String name) {
		this.questions = questions;
		this.name = name;
	}

	public List<RuntimeQuestion> getQuestions() {
		return questions;
	}

	public String getName() {
		return name;
	}
}
