package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.memory.RuntimeMemory;

public class BoolLiteral extends Literal implements Expression {
	private final boolean _value;
	
	public BoolLiteral(boolean _value, Token tokenInfo) {
		super(tokenInfo);
		this._value = _value;
	}

	@Override
	public BoolValue evaluate(RuntimeMemory mem) {
		return new BoolValue(_value);
	}

	@Override
	public Type getType() {
		return new BoolType();
	}

}
