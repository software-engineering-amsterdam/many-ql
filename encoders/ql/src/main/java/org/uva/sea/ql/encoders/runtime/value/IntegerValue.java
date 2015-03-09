package org.uva.sea.ql.encoders.runtime.value;

public class IntegerValue extends Value {

	private int value;

	public IntegerValue(int value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value add(Value otherValue) {
		int result = value + ((IntegerValue) otherValue).getValue();
		return new IntegerValue(result);
	}
}
