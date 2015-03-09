package org.uva.sea.ql.encoders.runtime.value;

public class StringValue extends Value {

	private String value;

	public StringValue(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
