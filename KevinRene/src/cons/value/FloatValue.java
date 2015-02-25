package cons.value;

import cons.Value;

@SuppressWarnings("rawtypes")
public class FloatValue extends Value<Float> {
	public FloatValue(float value) {
		super(value);
	}

	@Override
	public Value add(Value argument) {
		return argument.addFloat(getValue());
	}

	@Override
	public Value addInteger(int argument) {
		return new FloatValue(argument + getValue());
	}

	@Override
	public Value addFloat(float argument) {
		return new FloatValue(argument + getValue());
	}

	@Override
	public Value addString(String argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value divide(Value argument) {
		return argument.divideFloat(getValue());
	}

	@Override
	public Value divideInteger(int argument) {
		return new FloatValue(argument / getValue());
	}

	@Override
	public Value divideFloat(float argument) {
		return new FloatValue(argument / getValue());
	}

	@Override
	public Value multiply(Value argument) {
		return argument.multiplyFloat(getValue());
	}

	@Override
	public Value multiplyInteger(int argument) {
		return new FloatValue(argument * getValue());
	}

	@Override
	public Value multiplyFloat(float argument) {
		return new FloatValue(argument * getValue());
	}

	@Override
	public Value subtract(Value argument) {
		return argument.subtractFloat(getValue());
	}

	@Override
	public Value subtractInteger(int argument) {
		return new FloatValue(argument - getValue());
	}

	@Override
	public Value subtractFloat(float argument) {
		return new FloatValue(argument - getValue());
	}

	@Override
	public Value not() {
		throw new UnsupportedOperationException("Cannot negate a Float.");
	}

	@Override
	public Value positive() {
		return new FloatValue(getValue() < 0.0 ? getValue() * -1 : getValue());
	}

	@Override
	public Value negative() {
		return new FloatValue(getValue() * -1);
	}

	@Override
	public Value or(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value orBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualTo(Value argument) {
		return argument.notEqualToFloat(getValue());
	}

	@Override
	public Value notEqualToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualToInteger(int argument) {
		return new BooleanValue(argument != getValue());
	}

	@Override
	public Value notEqualToFloat(float argument) {
		return new BooleanValue(argument != getValue());
	}

	@Override
	public Value notEqualToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lowerThan(Value argument) {
		return argument.lowerThanFloat(getValue());
	}

	@Override
	public Value lowerThanInteger(int argument) {
		return new BooleanValue(argument < getValue());
	}

	@Override
	public Value lowerThanFloat(float argument) {
		return new BooleanValue(argument < getValue());
	}

	@Override
	public Value lowerOrEqual(Value argument) {
		return argument.lowerOrEqualFloat(getValue());
	}

	@Override
	public Value lowerOrEqualInteger(int argument) {
		return new BooleanValue(argument <= getValue());
	}

	@Override
	public Value lowerOrEqualFloat(float argument) {
		return new BooleanValue(argument <= getValue());
	}

	@Override
	public Value greaterThan(Value argument) {
		return argument.greaterThanFloat(getValue());
	}

	@Override
	public Value greaterThanInteger(int argument) {
		return new BooleanValue(argument > getValue());
	}

	@Override
	public Value greaterThanFloat(float argument) {
		return new BooleanValue(argument > getValue());
	}

	@Override
	public Value greaterOrEqual(Value argument) {
		return argument.greaterOrEqualThanFloat(getValue());
	}

	@Override
	public Value greaterOrEqualThanInteger(int argument) {
		return new BooleanValue(argument >= getValue());
	}

	@Override
	public Value greaterOrEqualThanFloat(float argument) {
		return new BooleanValue(argument >= getValue());
	}

	@Override
	public Value equalTo(Value argument) {
		return argument.equalToFloat(getValue());
	}

	@Override
	public Value equalToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value equalToInteger(int argument) {
		return new BooleanValue(argument == getValue());
	}

	@Override
	public Value equalToFloat(float argument) {
		return new BooleanValue(argument == getValue());
	}

	@Override
	public Value equalToString(String argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value and(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value andBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}
}
