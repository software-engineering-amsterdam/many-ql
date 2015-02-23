package org.uva.sea.ql.encoders.ast;

public class Expression extends AstNode {

	private String name;

	private Expression expression;

	private Expression leftHand;

	private Expression rightHand;

	private String operator;

	public Expression(String name) {
		this.name = name;
	}

	public Expression(Expression expression) {
		this.expression = expression;
	}

	public Expression(Expression leftHand, Expression rightHand, String operator) {
		this.leftHand = leftHand;
		this.rightHand = rightHand;
		this.operator = operator;
	}

	public String getName() {
		return name;
	}

	public Expression getExpression() {
		return expression;
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
}
