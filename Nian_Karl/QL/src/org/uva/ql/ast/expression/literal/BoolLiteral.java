package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.visitor.Visitor;

public class BoolLiteral extends Literal {
	
	private final Boolean value;

	public BoolLiteral(Boolean value,CodePosition pos) {
		super(pos);
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