package org.uva.ql.ast.value;


public class BoolValue extends Value {

	private final Boolean value;

	public BoolValue(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean value() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BoolValue){
			return value.equals(((BoolValue) obj).value());
			
		} else {
			throw new UnsupportedOperationException("BoolValue is only compariable with another BoolValue.");
		}
	}
	
	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Value not() {
		return new BoolValue(!value());
	}

	@Override
	public Value and(Value arg) {
		return arg.boolAnd(this);
	}

	@Override
	public Value boolAnd(BoolValue arg) {
		return new BoolValue(arg.value() && value());
	}

	@Override
	public Value or(Value arg) {
		return arg.boolOr(this);
	}

	@Override
	public Value boolOr(BoolValue arg) {
		return new BoolValue(arg.value() || value());
	}

	@Override
	public Value equal(Value arg) {
		return arg.boolEqual(this);
	}

	@Override
	public Value boolEqual(BoolValue arg) {
		return new BoolValue(arg.value() == value());
	}

	@Override
	public Value notEqual(Value arg) {
		return arg.boolNotEqual(this);
	}

	@Override
	public Value boolNotEqual(BoolValue arg) {
		return new BoolValue(arg.value() != value());
	}
	
}
