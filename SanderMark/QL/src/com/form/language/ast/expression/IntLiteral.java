package com.form.language.ast.expression;

import com.form.language.ast.values.IntValue;

public class IntLiteral implements PrimitiveExpression {
	private final int _value;
	
	public IntLiteral(int _value) {
		super();
		this._value = _value;
	}

	@Override
	public IntValue evaluate() {
		return new IntValue(_value);
	}
	
}
