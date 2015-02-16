package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.values.StringValue;

public class StringLiteral implements PrimitiveExpression {
	private final String value;
	
	public StringLiteral(String value) {
		super();
		this.value = value;
	}

	@Override
	public StringValue evaluate() {
		return new StringValue(value);
	}
	
}
