package com.form.language.ast.expression.literal;

import com.form.language.ast.type.StringType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.StringValue;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class StringLiteral extends Literal  {
    private final String value;

    public StringLiteral(String value, QLToken tokenInfo) {
	super(tokenInfo);
	this.value = value;
    }

    @Override
    public StringValue evaluate(Context context) {
	return new StringValue(value);
    }

    @Override
    public Type getType(Context context) {
	return new StringType();
    }

}
