package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.value.StringValue;

public class StringLitereal extends AbstractLiteral{

	public final String stringValue;
	
	public StringLitereal(String stringValue) {
		this.stringValue = stringValue;
	}

	@Override
	public StringValue interpretExpression() {
		return new StringValue(stringValue);
	}

}
