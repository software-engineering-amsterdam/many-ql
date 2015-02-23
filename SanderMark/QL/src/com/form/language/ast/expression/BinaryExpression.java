package com.form.language.ast.expression;

import com.form.language.ast.type.ErrorType;

public abstract class BinaryExpression implements Expression {
	public Expression left;
	public Expression right;
	public BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public Boolean isCorrectlyTyped() {
		return !this.getType().equals(new ErrorType());
	}
	
	
}