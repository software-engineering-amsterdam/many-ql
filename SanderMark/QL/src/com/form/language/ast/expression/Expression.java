package com.form.language.ast.expression;

import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;

public interface Expression {
	public abstract GenericValue<?> evaluate();
	public abstract Type getType();
	public abstract void getErrors(ErrorCollector errorCollector);
	public abstract void collectIds(IdCollector idCollector);
	public abstract Boolean isCorrectlyTyped();
	public abstract String showTokenInfo();
}