package nl.uva.sc.encoders.ql.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;

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

	public boolean containsQuestion(final String name) {
		return getAllQuestions().stream().anyMatch(question -> question.getName().equals(name));
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public String getName() {
		return name;
	}

}
