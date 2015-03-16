package org.uva.ql.ast.value;

public class StrValue extends Value {

	private final String value;

	public StrValue(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}
	
	public boolean equals(StrValue strValue) {
		return value.equals(strValue.value());
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
		return new BoolValue(arg.value().equals(value()));
	}

	@Override
	public Value notEqual(Value arg) {
		return arg.strNotEqual(this);
	}

	@Override
	public Value strNotEqual(StrValue arg) {
		return new BoolValue(!arg.value().equals(value()));
	}

	@Override
	public Value plus(Value arg) {
		return arg.StrPlus(this);
	}

	public Value StrPlus(StrValue arg) {
		return new StrValue(arg.value() + value());
	}
	
	@Override
	public boolean isDefined() {
		return true;
	}

}
