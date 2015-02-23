package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.value.Str;

public class StrLiteral extends Literal{
	
	private final String value;
	
	public StrLiteral(String value) {
		this.value = value;
	}
	
	@Override
	public Str evaluate() {
		return new Str(value);
	}

}
