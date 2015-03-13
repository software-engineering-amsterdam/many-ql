package org.uva.ql.ast.value;

public class StrValue extends Value {

	private final String value;

	public StrValue(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public Value equal(Value arg) {
		return arg.strEqual(this);
	}

	@Override
	public Value strEqual(StrValue arg) {
		return new BoolValue(arg.getValue().equals(getValue()));
	}

	@Override
	public Value notEqual(Value arg) {
		return arg.strNotEqual(this);
	}

	@Override
	public Value strNotEqual(StrValue arg) {
		return new BoolValue(!arg.getValue().equals(getValue()));
	}

	@Override
	public Value plus(Value arg) {
		return arg.StrPlus(this);
	}

	public Value StrPlus(StrValue arg) {
		return new StrValue(arg.getValue() + getValue());
	}

	@Override
	public boolean isUndefined() {
		if (value.equals("") || value == null) {
			return true;
		}
		return false;
	}

}
