package org.uva.sea.ql.model.literal;

public class StringLitereal extends AbstractLiteral<String> {

	public final String stringValue;
	
	public StringLitereal(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Override
	public String getValue() {
		return this.stringValue;
	}

}
