package ql.value;

import ql.Value;

public class StringValue extends Value<String> {
	public StringValue(String value) {
		super(value);
	}

	@Override
	public Value<?> add(Value<?> argument) {
		return argument.addString(getValue());
	}

	@Override
	public Value<String> addInteger(int argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value<String> addFloat(float argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value<String> addString(String argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value<String> divide(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> divideInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> divideFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> multiply(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> multiplyInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> multiplyFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> subtract(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> subtractInteger(int argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Float> subtractFloat(float argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> not() {
		throw new UnsupportedOperationException("Cannot negate a String.");
	}

	@Override
	public Value<String> positive() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<String> negative() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> or(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> orBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<?> notEqualTo(Value<?> argument) {
		return argument.notEqualToString(getValue());
	}

	@Override
	public Value<Boolean> notEqualToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
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
		return new BooleanValue(!argument.equals(getValue()));
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
		return argument.equalToString(getValue());
	}

	@Override
	public Value<Boolean> equalToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
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
		return new BooleanValue(argument.equals(getValue()));
	}

	@Override
	public Value<Boolean> and(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> andBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return "\"" + getValue().toString() + "\"";
	}
}
