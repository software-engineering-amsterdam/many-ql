package org.uva.sea.ql.encoders.ast;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire extends AstNode {

	private final String name;

	private final List<Statement> statements;

	public Questionnaire(TextLocation textLocation, String name, List<Statement> statements) {
		super(textLocation);
		this.name = name;
		this.statements = statements;
	}

	public List<Question> getQuestions() {
		List<Question> questions = new ArrayList<>();
		for (Statement statement : statements) {
			questions.addAll(statement.getQuestions());
		}
		return questions;
	}

	public Question getQuestion(String name) {
		for (Question question : getQuestions()) {
			if (question.getName().equals(name)) {
				return question;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

}
