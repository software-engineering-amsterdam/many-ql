package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.visitor.Visitor;

public class BoolLiteral extends Literal {
	
	private final Boolean value;

	public BoolLiteral(Boolean value) {
		this.value = value;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}
