package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.runtime.operator.UnaryOperator;

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
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
