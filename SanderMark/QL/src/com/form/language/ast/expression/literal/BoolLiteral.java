package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.memory.Context;

public class BoolLiteral extends Literal implements Expression {
	private final boolean _value;
	
	public BoolLiteral(boolean _value, Token tokenInfo) {
		super(tokenInfo);
		this._value = _value;
	}

	@Override
	public BoolValue evaluate(Context mem) {
		return new BoolValue(_value);
	}

	@Override
	public Type getType(Context mem) {
		return new BoolType();
	}

}
