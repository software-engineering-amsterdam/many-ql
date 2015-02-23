package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.value.Int;

public class IntLiteral extends Literal{
	
	private final Integer value;
	
	public IntLiteral(Integer value) {
		this.value = value;
	}
	
	@Override
	public Int evaluate() {
		return new Int(value);
	}
	
}
