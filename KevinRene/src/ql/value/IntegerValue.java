package ql.value;

import ql.Value;

public class IntegerValue extends Value<Integer> {
	public IntegerValue(Integer value) {
		super(value);
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}

	@Override
	public Value<?> add(Value<?> argument) {
		return argument.addInteger(getValue());
	}
	
	@Override
	public Value<Integer> addInteger(int argument) {
		return new IntegerValue(argument + getValue());
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
		return argument.divideInteger(getValue());
	}

	@Override
	public Value<Integer> divideInteger(int argument) {
		return new IntegerValue(argument / getValue());
	}

	@Override
	public Value<Float> divideFloat(float argument) {
		return new FloatValue(argument / getValue());
	}

	@Override
	public Value<?> multiply(Value<?> argument) {
		return argument.multiplyInteger(getValue());
	}

	@Override
	public Value<Integer> multiplyInteger(int argument) {
		return new IntegerValue(argument * getValue());
	}

	@Override
	public Value<Float> multiplyFloat(float argument) {
		return new FloatValue(argument * getValue());
	}

	@Override
	public Value<?> subtract(Value<?> argument) {
		return argument.subtractInteger(getValue());
	}

	@Override
	public Value<Integer> subtractInteger(int argument) {
		return new IntegerValue(argument - getValue());
	}

	@Override
	public Value<Float> subtractFloat(float argument) {
		return new FloatValue(argument - getValue());
	}

	@Override
	public Value<Integer> not() {
		throw new UnsupportedOperationException("Cannot negate an Integer.");
	}

	@Override
	public Value<Integer> positive() {
		return new IntegerValue(getValue() < 0.0 ? getValue() * -1 : getValue());
	}

	@Override
	public Value<Integer> negative() {
		return new IntegerValue(getValue() * -1);
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
		return argument.notEqualToInteger(getValue());
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
		return argument.lowerThanInteger(getValue());
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
		return argument.lowerOrEqualInteger(getValue());
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
		return argument.greaterThanInteger(getValue());
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
		return argument.greaterOrEqualThanInteger(getValue());
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
		return argument.equalToInteger(getValue());
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
