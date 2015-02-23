package cons.value;

import cons.Value;

@SuppressWarnings("rawtypes")
public class StringValue extends Value<String> {
	public StringValue(String value) {
		super(value);
	}

	@Override
	public Value add(Value argument) {
		return argument.addString(getValue());
	}

	@Override
	public Value addInteger(int argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value addFloat(float argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value addString(String argument) {
		return new StringValue(argument + getValue());
	}

	@Override
	public Value divide(Value argument) {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException("Cannot negate a String.");
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
		throw new UnsupportedOperationException();
	}

	@Override
	public Value orBoolean(boolean argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualTo(Value argument) {
		return argument.notEqualToString(getValue());
	}

	@Override
	public Value notEqualToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
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
		return new BooleanValue(!argument.equals(getValue()));
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
		return argument.equalToString(getValue());
	}

	@Override
	public Value equalToBoolean(boolean argument) {
		throw new UnsupportedOperationException();
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
		return new BooleanValue(argument.equals(getValue()));
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
