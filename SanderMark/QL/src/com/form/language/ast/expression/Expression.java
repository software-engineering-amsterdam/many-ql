package com.form.language.ast.expression;

import com.form.language.ast.ASTNode;
import com.form.language.ast.values.GenericValue;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

public interface Expression extends ASTNode {
	public abstract Boolean isCorrectlyTyped(Context context);
	public abstract String showTokenInfo();
	public abstract GenericValue<?> evaluate(Context context);
	public abstract void collectIds(IdCollection idCollection);
}