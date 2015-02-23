package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class Not extends UnaryExpression implements Expression {

	public Not(Expression value) {
		super(value);
	}

	@Override
	public BoolValue evaluate() {
		return new BoolValue(!((BoolValue)value.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(super.value.getType().isBoolType()) return new BoolType();
		return new ErrorType();
	}

}
