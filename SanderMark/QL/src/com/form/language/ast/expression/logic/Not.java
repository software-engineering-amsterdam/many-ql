package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.BoolLiteral;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class Not extends UnaryExpression implements Expression {

	public Not(Expression value) {
		super(value);
	}

	@Override
	public BoolValue evaluate() {
		return ((BoolLiteral)value).evaluate().Not();
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
