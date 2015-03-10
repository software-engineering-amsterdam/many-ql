package ql.value;

import ql.Value;

@SuppressWarnings("rawtypes")
public class BooleanValue extends Value<Boolean> {
	public BooleanValue(Boolean value) {
		super(value);
	}

	@Override
	public Value add(Value argument) {
		throw new UnsupportedOperationException("Cannot add to a Boolean.");
	}

	@Override
	public Value addInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value addFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value addString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value divide(Value argument) {
		throw new UnsupportedOperationException("Cannot divideide a Boolean.");
	}

	@Override
	public Value divideInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value divideFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value multiply(Value argument) {
		throw new UnsupportedOperationException("Cannot multiplytiply by a Boolean.");
	}

	@Override
	public Value multiplyInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value multiplyFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value subtract(Value argument) {
		throw new UnsupportedOperationException("Cannot subtracttract from a Boolean.");
	}

	@Override
	public Value subtractInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value subtractFloat(float argument) {
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
		return argument.orBoolean(getValue());
	}

	@Override
	public Value orBoolean(boolean argument) {
		return new BooleanValue(argument || getValue());
	}

	@Override
	public Value notEqualTo(Value argument) {
		return argument.notEqualToBoolean(getValue());
	}

	@Override
	public Value notEqualToBoolean(boolean argument) {
		return new BooleanValue(argument != getValue());
	}

	@Override
	public Value notEqualToInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualToFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThan(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThanInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThanFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerOrEqual(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerOrEqualInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerOrEqualFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterThan(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterThanInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterThanFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterOrEqual(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterOrEqualThanInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value greaterOrEqualThanFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalTo(Value argument) {
		return argument.equalToBoolean(getValue());
	}

	@Override
	public Value equalToBoolean(boolean argument) {
		return new BooleanValue(argument == getValue());
	}

	@Override
	public Value equalToInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalToFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value and(Value argument) {
		return argument.andBoolean(getValue());
	}

	@Override
	public Value andBoolean(boolean argument) {
		return new BooleanValue(argument && getValue());
	}
}
