package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.StringValue;

public class StringLiteral implements Expression {
	private final String value;
	
	public StringLiteral(String value) {
		super();
		this.value = value;
	}

	@Override
	public StringValue evaluate() {
		return new StringValue(value);
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
