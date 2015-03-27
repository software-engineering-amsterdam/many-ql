package com.form.language.ast.expression.literal;

import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class IntLiteral extends Literal {
    private final int value;

    public IntLiteral(int value, QLToken tokenInfo) {
	super(tokenInfo);
	this.value = value;
    }

    @Override
    public IntValue evaluate(Context context) {
	return new IntValue(value);
    }

    @Override
    public Type getType(Context context) {
	return new IntType();
    }

}
