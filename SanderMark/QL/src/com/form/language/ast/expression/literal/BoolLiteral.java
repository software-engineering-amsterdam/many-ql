package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.values.BoolValue;

public class BoolLiteral implements PrimitiveExpression {
	private final boolean _value;
	
	public BoolLiteral(boolean _value) {
		super();
		this._value = _value;
	}

	@Override
	public BoolValue evaluate() {
		return new BoolValue(_value);
	}
	
}
