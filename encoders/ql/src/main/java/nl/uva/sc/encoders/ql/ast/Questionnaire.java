package nl.uva.sc.encoders.ql.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;

public class Questionnaire extends AstNodeWithLocation {

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

	public boolean containsQuestion(final String name) {
		return getAllQuestions().stream().anyMatch(p -> p.getName().equals(name));
	}

	public Question getQuestion(String name) {
		getAllQuestions().stream().findAny();
		for (Question question : getAllQuestions()) {
			if (question.getName().equals(name)) {
				return question;
			}
		}
		throw new IllegalStateException("Question " + name + " should be in questionnaire");
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public String getName() {
		return name;
	}

}
