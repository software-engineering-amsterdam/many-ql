package nl.uva.se.ast.statement;

import nl.uva.se.ast.type.Type;
import nl.uva.se.visitor.StatementVisitor;

public class Question extends Statement {

	private final String id;
	private final Type type;
	private final String question;
	
	public Question(int lineNumber, int offset, String id, Type type,
			String question) {
		super(lineNumber, offset);
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

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
	
}
