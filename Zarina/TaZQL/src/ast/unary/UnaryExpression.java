package ast.unary;

import ast.expression.Expression;

public abstract class UnaryExpression extends Expression {
	private final Expression expression;
		
	public UnaryExpression (Expression expression) {
			this.expression = expression;
	}
				
	public Expression getUnaryExpression() {
			return expression;
		}
}

