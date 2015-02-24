package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.StringType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.StringValue;

public class StringLiteral extends Literal implements Expression {
	private final String value;
	
	public StringLiteral(String value, Token tokenInfo) {
		super(tokenInfo);
		this.value = value;
	}

	@Override
	public StringValue evaluate() {
		return new StringValue(value);
	}

	@Override
	public Type getType() {
		return new StringType();
	}
	
}
