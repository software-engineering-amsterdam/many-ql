package ql.value;

import ql.Value;

public class BooleanValue extends Value<Boolean> {
	public BooleanValue(Boolean value) {
		super(value);
	}

	@Override
	public Value<Boolean> add(Value<?> argument) {
		throw new UnsupportedOperationException("Cannot add to a Boolean.");
	}

	@Override
	public Value<Boolean> addInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> addFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> addString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> divide(Value<?> argument) {
		throw new UnsupportedOperationException("Cannot divideide a Boolean.");
	}

	@Override
	public Value<Boolean> divideInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> divideFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> multiply(Value<?> argument) {
		throw new UnsupportedOperationException("Cannot multiplytiply by a Boolean.");
	}

	@Override
	public Value<Boolean> multiplyInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> multiplyFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> subtract(Value<?> argument) {
		throw new UnsupportedOperationException("Cannot subtracttract from a Boolean.");
	}

	@Override
	public Value<Boolean> subtractInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> subtractFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> not() {
		return new BooleanValue(!getValue());
	}

	@Override
	public Value<Boolean> positive() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> negative() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<?> or(Value<?> argument) {
		return argument.orBoolean(getValue());
	}

	@Override
	public Value<Boolean> orBoolean(boolean argument) {
		return new BooleanValue(argument || getValue());
	}

	@Override
	public Value<?> notEqualTo(Value<?> argument) {
		return argument.notEqualToBoolean(getValue());
	}

	@Override
	public Value<Boolean> notEqualToBoolean(boolean argument) {
		return new BooleanValue(argument != getValue());
	}

	@Override
	public Value<Boolean> notEqualToInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> notEqualToFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> notEqualToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> lowerThan(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> lowerThanInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> lowerThanFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> lowerOrEqual(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> lowerOrEqualInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> lowerOrEqualFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> greaterThan(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> greaterThanInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> greaterThanFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> greaterOrEqual(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> greaterOrEqualThanInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> greaterOrEqualThanFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<?> equalTo(Value<?> argument) {
		return argument.equalToBoolean(getValue());
	}

	@Override
	public Value<Boolean> equalToBoolean(boolean argument) {
		return new BooleanValue(argument == getValue());
	}

	@Override
	public Value<Boolean> equalToInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> equalToFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> equalToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<?> and(Value<?> argument) {
		return argument.andBoolean(getValue());
	}

	@Override
	public Value<Boolean> andBoolean(boolean argument) {
		return new BooleanValue(argument && getValue());
	}
}
