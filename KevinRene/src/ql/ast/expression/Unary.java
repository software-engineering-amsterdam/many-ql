package ql.ast.expression;

import java.util.Arrays;

import ql.ast.Expression;

public abstract class Unary extends Expression {
	
	protected Expression operand;
	protected String operator;
	
	public Unary(Expression operand, String operator) {
		super(Arrays.asList(operand));
		this.operand = operand;
		this.operator = operator;
	}
	
	@Override
	public String toString() {
		return this.operator + this.operand.toString();
	}
	
	public Expression getExpression() {
		return this.operand;
	}
}