package nl.uva.se.ast.statement;

import nl.uva.se.constant.Type;

public class Question implements Statement {

	private final String id;
	private final Type type;
	private final String question;
	
	public Question(String id, Type type, String question) {
		this.id = id;
		this.type = type;
		this.question = question;
	}

	public String getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public String getQuestion() {
		return question;
	}
	
}
