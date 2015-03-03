package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;
import com.form.language.memory.RuntimeMemory;

public class IntLiteral extends Literal implements Expression {
	private final int _value;
	
	public IntLiteral(int _value, Token tokenInfo) {
		super(tokenInfo);
		this._value = _value;
	}

	@Override
	public IntValue evaluate(RuntimeMemory mem) {
		return new IntValue(_value);
	}

	@Override
	public Type getType() {
		return new IntType();
	}
	

}
