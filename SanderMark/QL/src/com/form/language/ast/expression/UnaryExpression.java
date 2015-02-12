package com.form.language.ast.expression;

public abstract class UnaryExpression {
	public PrimitiveExpression value;
	public UnaryExpression(PrimitiveExpression value) {
		this.value = value;
	}
}