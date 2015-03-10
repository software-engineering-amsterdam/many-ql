package nl.uva.se.ql.ast.expression.literal;

import nl.uva.se.ql.ast.expression.Expression;

public abstract class AbstractLiteral<T> extends Expression {
	
	private final T value;
	
	public AbstractLiteral(int lineNumber, int offset, T value) {
		super(lineNumber, offset);
		this.value = value;
	}

	public T getValue() {
		return value;
	}

}
