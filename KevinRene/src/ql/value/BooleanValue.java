package ql.value;

import ql.Value;

public class BooleanValue implements Value {
	private final boolean value;
	
	@Override
	public boolean isUndefined() {
		return false;
	}

	@Override
	public boolean isNumeric() {
		return false;
	}
	
	public BooleanValue(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}
	
	@Override
	public Value add(Value argument) {
		throw new UnsupportedOperationException("Cannot add to a Boolean.");
	}

	@Override
	public Value addInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value addFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value divide(Value argument) {
		throw new UnsupportedOperationException("Cannot divideide a Boolean.");
	}

	@Override
	public Value divideInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value divideFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value multiply(Value argument) {
		throw new UnsupportedOperationException("Cannot multiplytiply by a Boolean.");
	}

	@Override
	public Value multiplyInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value multiplyFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value subtract(Value argument) {
		throw new UnsupportedOperationException("Cannot subtracttract from a Boolean.");
	}

	@Override
	public Value subtractInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value subtractFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value not() {
		return new BooleanValue(!getValue());
	}

	@Override
	public Value positive() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value negative() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value or(Value argument) {
		return argument.orBoolean(this);
	}

	@Override
	public Value orBoolean(BooleanValue argument) {
		return new BooleanValue(argument.getValue() || getValue());
	}

	@Override
	public Value notEqualTo(Value argument) {
		return argument.notEqualToBoolean(this);
	}

	@Override
	public Value notEqualToBoolean(BooleanValue argument) {
		return new BooleanValue(argument.getValue() != getValue());
	}

	@Override
	public Value notEqualToInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualToFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualToString(StringValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThan(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThanInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThanFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerOrEqual(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerOrEqualInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerOrEqualFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterThan(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterThanInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterThanFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterOrEqual(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterOrEqualThanInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterOrEqualThanFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalTo(Value argument) {
		return argument.equalToBoolean(this);
	}

	@Override
	public Value equalToBoolean(BooleanValue argument) {
		return new BooleanValue(argument.getValue() == getValue());
	}

	@Override
	public Value equalToInteger(IntegerValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalToFloat(FloatValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalToString(StringValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value and(Value argument) {
		return argument.andBoolean(this);
	}

	@Override
	public Value andBoolean(BooleanValue argument) {
		return new BooleanValue(argument.getValue() && getValue());
	}

	@Override
	public int hashCode() {
		return Boolean.hashCode(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BooleanValue) {
			return getValue().equals(((BooleanValue) obj).getValue());
		}
		
		return false;
	}

	@Override
	public String toString() {
		return getValue().toString();
	}
}
