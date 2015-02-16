package org.uva.sea.ql.model.literal;

import org.uva.sea.ql.model.value.StringValue;

public class StringLitereal extends AbstractLiteral{

	public final String stringValue;
	
	public StringLitereal(String stringValue) {
		this.stringValue = stringValue;
	}

	@Override
	public StringValue evaluateExpression() {
		return new StringValue(stringValue);
	}
	
}