package com.form.language.ast;

import com.form.language.ast.values.GenericValue;

public interface AST {
	public abstract Boolean typeCorrect(Error e);
	public abstract GenericValue<?> evaluate();
}
