package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.value.Str;
import ql.ast.visitor.Visitor;

public class StrLiteral extends Literal{
	
	private final String value;
	
	public StrLiteral(String value) {
		this.value = value;
	}
	

	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
