package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;
import com.form.language.memory.Context;

public class IntLiteral extends Literal {
    private final int _value;

    public IntLiteral(int _value, Token tokenInfo) {
	super(tokenInfo);
	this._value = _value;
    }

    @Override
    public IntValue evaluate(Context context) {
	return new IntValue(_value);
    }

    @Override
    public Type getType(Context context) {
	return new IntType();
    }

}
