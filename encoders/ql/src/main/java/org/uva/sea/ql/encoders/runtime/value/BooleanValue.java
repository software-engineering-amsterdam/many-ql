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

	@Override
	public Value and(Value otherValue) {
		boolean result = value && ((BooleanValue) otherValue).getValue();
		return new BooleanValue(result);
	}

	@Override
	public Value or(Value otherValue) {
		boolean result = value || ((BooleanValue) otherValue).getValue();
		return new BooleanValue(result);
	}

	@Override
	public BooleanValue not() {
		return new BooleanValue(!value);
	}
}
