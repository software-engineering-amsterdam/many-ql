package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.value.Bool;
import ql.ast.visitor.Visitor;

public class BoolLiteral extends Literal{
	
	private final Boolean value;
	
	public BoolLiteral(Boolean value) {
		this.value = value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
}
