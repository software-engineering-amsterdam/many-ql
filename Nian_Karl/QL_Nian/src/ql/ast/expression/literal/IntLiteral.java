package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.visitor.Visitor;

public class IntLiteral extends Literal{
	
	private final Integer value;
	
	public IntLiteral(Integer value) {
		this.value = value;
	}
	
	public Integer getValue(){
		return value;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
}
