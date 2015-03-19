package com.form.language.ast.expression.literal;

import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.error.QLToken;
import com.form.language.memory.Context;

public class BoolLiteral extends Literal  {
    private final boolean value;

    public BoolLiteral(boolean _value, QLToken tokenInfo) {
	super(tokenInfo);
	this.value = _value;
    }

    @Override
    public BoolValue evaluate(Context context) {
	return new BoolValue(value);
    }

    @Override
    public Type getType(Context context) {
	return new BoolType();
    }

}
