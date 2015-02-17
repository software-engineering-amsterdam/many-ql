package nl.uva.se.ast.expression.literal;

import nl.uva.se.ast.expression.Expression;

public abstract class AbstractLiteral extends Expression {
	
	private final String name;
	
	public AbstractLiteral(int lineNumber, int offset, String name) {
		super(lineNumber, offset);
		this.name = name;
	}

	public String getName() {
		return name;
	}	
	
}
