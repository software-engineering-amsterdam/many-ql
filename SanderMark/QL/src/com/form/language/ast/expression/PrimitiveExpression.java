package com.form.language.ast.expression;

import com.form.language.ast.AST;
import com.form.language.ast.values.GenericValue;

public interface PrimitiveExpression extends AST {
	public abstract GenericValue<?> evaluate();
		
}