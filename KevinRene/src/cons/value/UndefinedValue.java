package cons.value;

import cons.Value;

@SuppressWarnings("rawtypes")
public class UndefinedValue extends Value {

	public UndefinedValue() {
		super(null);
	}

	@Override
	public Value add(Value argument) {
		return this;
	}

	@Override
	public Value divide(Value argument) {
		return this;
	}

	@Override
	public Value multiply(Value argument) {
		return this;
	}
	
	@Override
	public Value subtract(Value argument) {
		return this;
	}

	@Override
	public Value not() {
		return this;
	}

	@Override
	public Value positive() {
		return this;
	}

	@Override
	public Value negative() {
		return this;
	}

	@Override
	public Value or(Value argument) {
		return this;
	}

	@Override
	public Value notEqualTo(Value argument) {
		return this;
	}

	@Override
	public Value lowerThan(Value argument) {
		return this;
	}

	@Override
	public Value lowerOrEqual(Value argument) {
		return this;
	}

	@Override
	public Value greaterThan(Value argument) {
		return this;
	}

	@Override
	public Value greaterOrEqual(Value argument) {
		return this;
	}

	@Override
	public Value equalTo(Value argument) {
		return this;
	}

	@Override
	public Value and(Value argument) {
		return this;
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
	public Value divideInteger(int argument) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Value divideFloat(float argument) {
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
	public Value subtractInteger(int argument) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Value subtractFloat(float argument) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Value orBoolean(boolean argument) {
		throw new UnsupportedOperationException();
		
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
	public Value lowerOrEqualInteger(int argument) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Value lowerOrEqualFloat(float argument) {
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
	public Value greaterOrEqualThanInteger(int argument) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Value greaterOrEqualThanFloat(float argument) {
		throw new UnsupportedOperationException();
		
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
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Value andBoolean(boolean argument) {
		throw new UnsupportedOperationException();
		
	}

}
