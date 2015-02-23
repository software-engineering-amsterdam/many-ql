package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.value.Bool;

public class BoolLiteral extends Literal{
	
	private final Boolean value;
	
	public BoolLiteral(Boolean value) {
		this.value = value;
	}
	
	@Override
	public Bool evaluate() {
		return new Bool(value);
	}
	
}
