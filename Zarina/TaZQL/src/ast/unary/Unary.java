package ast.unary;

import ast.expression.Expression;

public abstract class Unary extends Expression {
	private final Expression expression;
	
	public Unary (Expression expression) {
		this.expression = expression;
	}
	
	public Expression getUnaryExpression() {
		return expression;
	}
}