package org.uva.sea.ql.encoders.ast;

public class OperatorExpression extends Expression {

	private String operator;

	private Expression leftHand;

	private Expression rightHand;

	public OperatorExpression(TextLocation textLocation, Expression leftHand,
			Expression rightHand, String operator) {
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

	public String getOperator() {
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

}
