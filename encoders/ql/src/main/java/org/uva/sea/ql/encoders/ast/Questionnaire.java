package org.uva.sea.ql.encoders.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.encoders.ast.statement.Question;
import org.uva.sea.ql.encoders.ast.statement.Statement;

public class Questionnaire extends AstNode {

	private final String name;

	private final List<Statement> statements;

	public Questionnaire(TextLocation textLocation, String name, List<Statement> statements) {
		super(textLocation);
		this.name = name;
		this.statements = statements;
	}

	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<>();
		for (Statement statement : statements) {
			statement.collectQuestions(questions);
		}
		return questions;
	}

	public Question getQuestion(String name) {
		for (Question question : getAllQuestions()) {
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
