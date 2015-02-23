package com.form.language.ast.expression;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.type.Type;

public interface Expression {
	public abstract GenericValue<?> evaluate();
	public abstract Type getType();
}