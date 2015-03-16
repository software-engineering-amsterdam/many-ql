package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.operator.UnaryOperator;
import org.uva.sea.ql.encoders.visitor.ExpressionVisitor;

public class UnaryExpression extends Expression {

	private final UnaryOperator operator;

	private final Expression expression;

	public UnaryExpression(TextLocation textLocation, UnaryOperator operator, Expression expression) {
		super(textLocation);
		this.operator = operator;
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public UnaryOperator getOperator() {
		return operator;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
