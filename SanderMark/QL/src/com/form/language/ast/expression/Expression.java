package com.form.language.ast.expression;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;

public interface Expression {
	public abstract GenericValue<?> evaluate();
	public abstract Type getType();
	public abstract ErrorCollector getErrors(ErrorCollector errs);
	public abstract Boolean isCorrectlyTyped();
	public abstract String showTokenInfo();
}