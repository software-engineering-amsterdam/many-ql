package org.uva.sea.ql.encoders.ast;

public class UnaryExpression extends Expression {

	private final String operator;

	private final Expression expression;

	public UnaryExpression(TextLocation textLocation, String operator, Expression expression) {
		super(textLocation);
		this.operator = operator;
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public String getOperator() {
		return operator;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
