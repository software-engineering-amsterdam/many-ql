package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class BoolLiteral implements Expression {
	private final boolean _value;
	
	public BoolLiteral(boolean _value) {
		super();
		this._value = _value;
	}

	@Override
	public BoolValue evaluate() {
		return new BoolValue(_value);
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
