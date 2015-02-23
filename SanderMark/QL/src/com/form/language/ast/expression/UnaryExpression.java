package com.form.language.ast.expression;

import com.form.language.ast.type.ErrorType;

public abstract class UnaryExpression implements Expression{
	public Expression value;
	public UnaryExpression(Expression value) {
		this.value = value;
	}
	
	@Override
	public Boolean isCorrectlyTyped() {
		return !this.getType().equals(new ErrorType());
	}
}