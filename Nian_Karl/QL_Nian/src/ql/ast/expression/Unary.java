package ql.ast.expression;

import ql.ast.value.Value;

public abstract class Unary extends Expression{
	
	private final Expression operand;
	
	public Unary(Expression operand){
		this.operand = operand;
	}
	
	public Expression getExpression(){
		return this.operand;
	}
	
	@Override
	public abstract Value<?> evaluate();
}
