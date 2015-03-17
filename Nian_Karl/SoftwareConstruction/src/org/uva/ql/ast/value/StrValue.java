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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof StrValue){
			return value.equals(((StrValue) obj).value());
			
		} else {
			throw new UnsupportedOperationException("StrValue is only compariable with another StrValue.");
		}
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
