package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.StringType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.Context;

public class StringLiteral extends Literal implements Expression {
	private final String value;
	
	public StringLiteral(String value, Token tokenInfo) {
		super(tokenInfo);
		this.value = value;
	}

	@Override
	public StringValue evaluate(Context mem) {
		return new StringValue(value);
	}

	@Override
	public Type getType(Context mem) {
		return new StringType();
	}
	
}
