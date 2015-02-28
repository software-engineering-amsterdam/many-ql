package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.visitor.Visitor;

public class Identifier extends Literal {

	private final String value;

	public Identifier(String value,CodePosition pos) {
		super(pos);
		this.value = value;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
