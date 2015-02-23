package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;

public class IntLiteral extends Literal implements Expression {
	private final int _value;
	
	public IntLiteral(int _value) {
		super();
		this._value = _value;
	}

	@Override
	public IntValue evaluate() {
		return new IntValue(_value);
	}

	@Override
	public Type getType() {
		return new IntType();
	}
	
}
