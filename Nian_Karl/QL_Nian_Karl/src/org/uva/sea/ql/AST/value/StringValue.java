package org.uva.sea.ql.AST.value;

public class StringValue extends AbstractValue<String> {

	private final String stringValue;

	public StringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Override
	public String getValue() {
		return stringValue;
	}
}
