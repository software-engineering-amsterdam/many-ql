package org.uva.sea.ql.encoders.runtime.value;

public class StringValue extends Value {

	private final String value;

	public StringValue(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public StringValue add(Value otherValue) {
		String result = value + ((StringValue) otherValue).getValue();
		return new StringValue(result);
	}
}
