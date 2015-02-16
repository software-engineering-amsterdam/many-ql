package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.BoolLiteral;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.values.BoolValue;

public class Not extends UnaryExpression implements PrimitiveExpression {

	public Not(PrimitiveExpression value) {
		super(value);
	}

	@Override
	public BoolValue evaluate() {
		return ((BoolLiteral)value).evaluate().Not();
	}

}
