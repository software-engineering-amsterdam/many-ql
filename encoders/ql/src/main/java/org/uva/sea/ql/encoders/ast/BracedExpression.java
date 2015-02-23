package org.uva.sea.ql.encoders.ast;

public class BracedExpression extends Expression {

	private Expression expression;

	public BracedExpression(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(expression);
		builder.append(")");
		return builder.toString();
	}

}
