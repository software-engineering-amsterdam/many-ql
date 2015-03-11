package ql.value;

import ql.Value;

public class FloatValue extends Value<Float> {
	public FloatValue(float value) {
		super(value);
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}

	@Override
	public Value<?> add(Value<?> argument) {
		return argument.addFloat(getValue());
	}

	@Override
	public Value<Float> addInteger(int argument) {
		return new FloatValue(argument + getValue());
	}

	@Override
	public Value<Float> addFloat(float argument) {
		return new FloatValue(argument + getValue());
	}

	@Override
	public Value<String> addString(String argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value<?> divide(Value<?> argument) {
		return argument.divideFloat(getValue());
	}

	@Override
	public Value<Float> divideInteger(int argument) {
		return new FloatValue(argument / getValue());
	}

	@Override
	public Value<Float> divideFloat(float argument) {
		return new FloatValue(argument / getValue());
	}

	@Override
	public Value<?> multiply(Value<?> argument) {
		return argument.multiplyFloat(getValue());
	}

	@Override
	public Value<Float> multiplyInteger(int argument) {
		return new FloatValue(argument * getValue());
	}

	@Override
	public Value<Float> multiplyFloat(float argument) {
		return new FloatValue(argument * getValue());
	}

	@Override
	public Value<?> subtract(Value<?> argument) {
		return argument.subtractFloat(getValue());
	}

	@Override
	public Value<Float> subtractInteger(int argument) {
		return new FloatValue(argument - getValue());
	}

	@Override
	public Value<Float> subtractFloat(float argument) {
		return new FloatValue(argument - getValue());
	}

	@Override
	public Value<Float> not() {
		throw new UnsupportedOperationException("Cannot negate a Float.");
	}

	@Override
	public Value<Float> positive() {
		return new FloatValue(getValue() < 0.0 ? getValue() * -1 : getValue());
	}

	@Override
	public Value<Float> negative() {
		return new FloatValue(getValue() * -1);
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
		return argument.notEqualToFloat(getValue());
	}

	@Override
	public Value<Boolean> notEqualToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> notEqualToInteger(int argument) {
		return new BooleanValue(argument != getValue());
	}

	@Override
	public Value<Boolean> notEqualToFloat(float argument) {
		return new BooleanValue(argument != getValue());
	}

	@Override
	public Value<Boolean> notEqualToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<?> lowerThan(Value<?> argument) {
		return argument.lowerThanFloat(getValue());
	}

	@Override
	public Value<Boolean> lowerThanInteger(int argument) {
		return new BooleanValue(argument < getValue());
	}

	@Override
	public Value<Boolean> lowerThanFloat(float argument) {
		return new BooleanValue(argument < getValue());
	}

	@Override
	public Value<?> lowerOrEqual(Value<?> argument) {
		return argument.lowerOrEqualFloat(getValue());
	}

	@Override
	public Value<Boolean> lowerOrEqualInteger(int argument) {
		return new BooleanValue(argument <= getValue());
	}

	@Override
	public Value<Boolean> lowerOrEqualFloat(float argument) {
		return new BooleanValue(argument <= getValue());
	}

	@Override
	public Value<?> greaterThan(Value<?> argument) {
		return argument.greaterThanFloat(getValue());
	}

	@Override
	public Value<Boolean> greaterThanInteger(int argument) {
		return new BooleanValue(argument > getValue());
	}

	@Override
	public Value<Boolean> greaterThanFloat(float argument) {
		return new BooleanValue(argument > getValue());
	}

	@Override
	public Value<?> greaterOrEqual(Value<?> argument) {
		return argument.greaterOrEqualThanFloat(getValue());
	}

	@Override
	public Value<Boolean> greaterOrEqualThanInteger(int argument) {
		return new BooleanValue(argument >= getValue());
	}

	@Override
	public Value<Boolean> greaterOrEqualThanFloat(float argument) {
		return new BooleanValue(argument >= getValue());
	}

	@Override
	public Value<?> equalTo(Value<?> argument) {
		return argument.equalToFloat(getValue());
	}

	@Override
	public Value<Boolean> equalToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> equalToInteger(int argument) {
		return new BooleanValue(argument == getValue());
	}

	@Override
	public Value<Boolean> equalToFloat(float argument) {
		return new BooleanValue(argument == getValue());
	}

	@Override
	public Value<Boolean> equalToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> and(Value<?> argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value<Boolean> andBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}
}
