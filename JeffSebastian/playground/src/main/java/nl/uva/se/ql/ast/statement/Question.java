package nl.uva.se.ql.ast.statement;

import nl.uva.se.ql.ast.type.Type;

public class Question extends Statement {

	private final String id;
	private final Type type;
	private final String label;
	
	public Question(int lineNumber, int offset, String id, Type type,
			String label) {
		super(lineNumber, offset);
		this.id = id;
		this.type = type;
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Question) {
			return ((Question) obj).getId().equals(id);
		}
		
		return false;
	}
	
}
