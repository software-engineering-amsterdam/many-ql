package com.form.language.ast.expression;

public abstract class UnaryExpression {
	public Expression value;
	public UnaryExpression(Expression value) {
		this.value = value;
	}
}