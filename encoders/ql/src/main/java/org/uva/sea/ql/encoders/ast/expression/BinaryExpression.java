package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.runtime.operator.BinaryOperator;

public class BinaryExpression extends Expression {

	private BinaryOperator binaryOperator;

	private Expression leftHand;

	private Expression rightHand;

	public BinaryExpression(TextLocation textLocation, Expression leftHand, Expression rightHand, BinaryOperator binaryOperator) {
		super(textLocation);
		this.leftHand = leftHand;
		this.rightHand = rightHand;
		this.binaryOperator = binaryOperator;
	}

	public Expression getLeftHand() {
		return leftHand;
	}

	public Expression getRightHand() {
		return rightHand;
	}

	public BinaryOperator getOperator() {
		return binaryOperator;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(leftHand);
		builder.append(" ");
		builder.append(binaryOperator);
		builder.append(" ");
		builder.append(rightHand);
		return builder.toString();
	}

}
