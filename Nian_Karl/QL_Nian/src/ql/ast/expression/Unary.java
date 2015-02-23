package ql.ast.expression;

import ql.ast.value.Value;
import ql.ast.visitor.Visitor;

public abstract class Unary extends Expression{
	
	private final Expression operand;
	
	public Unary(Expression operand){
		this.operand = operand;
	}
	
	public Expression getExpression(){
		return this.operand;
	}
	

	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
