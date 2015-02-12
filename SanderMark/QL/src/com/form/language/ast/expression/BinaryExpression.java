package com.form.language.ast.expression;

public abstract class BinaryExpression {
	public PrimitiveExpression left;
	public PrimitiveExpression right;
	public BinaryExpression(PrimitiveExpression left, PrimitiveExpression right) {
		this.left = left;
		this.right = right;
	}
}