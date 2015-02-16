package org.uva.sea.ql.model.value;

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
