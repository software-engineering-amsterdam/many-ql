package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.operator.BinaryOperator;
import org.uva.sea.ql.encoders.visitor.ExpressionVisitor;

public class BinaryExpression extends Expression {

	private BinaryOperator operator;

	private Expression leftHand;

	private Expression rightHand;

	public BinaryExpression(TextLocation textLocation, Expression leftHand, Expression rightHand, BinaryOperator operator) {
		super(textLocation);
		this.leftHand = leftHand;
		this.rightHand = rightHand;
		this.operator = operator;
	}

	public Expression getLeftHand() {
		return leftHand;
	}

	public Expression getRightHand() {
		return rightHand;
	}

	public BinaryOperator getOperator() {
		return operator;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(leftHand);
		builder.append(" ");
		builder.append(operator);
		builder.append(" ");
		builder.append(rightHand);
		return builder.toString();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
