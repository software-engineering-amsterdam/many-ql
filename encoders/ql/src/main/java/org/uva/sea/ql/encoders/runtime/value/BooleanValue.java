package org.uva.sea.ql.encoders.runtime.value;

public class BooleanValue extends Value {

	private Boolean value;

	public BooleanValue(Boolean value) {
		this.value = value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
}
