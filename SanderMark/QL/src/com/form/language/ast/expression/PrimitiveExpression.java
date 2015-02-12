package com.form.language.ast.expression;

import com.form.language.ast.values.GenericValue;

public interface PrimitiveExpression {
	public abstract GenericValue<?> evaluate();

}