package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.Expression;

public abstract class Literal implements Expression {


	@Override
	public Boolean isCorrectlyTyped() {
		return true;
	}

}
