package com.form.language.ast.expression.math;

import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

public class Negation extends UnaryExpression implements PrimitiveExpression {
	
	public Negation(PrimitiveExpression value) {
		super(value);
	}

	@Override
	public GenericValue<Integer> evaluate() {
		return new IntValue(-((IntValue)super.value).evaluate());
	}
	
	
}
