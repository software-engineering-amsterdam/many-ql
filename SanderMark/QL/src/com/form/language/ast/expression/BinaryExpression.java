package com.form.language.ast.expression;

public abstract class BinaryExpression implements Expression {
	public Expression left;
	public Expression right;
	public BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}