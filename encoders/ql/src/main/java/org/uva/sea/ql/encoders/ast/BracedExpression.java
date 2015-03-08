package org.uva.sea.ql.encoders.ast;

public class BracedExpression extends Expression {

	private Expression expression;

	public BracedExpression(TextLocation textLocation, Expression expression) {
		super(textLocation);
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

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
