package cons.value;

import cons.Value;

@SuppressWarnings("rawtypes")
public class UndefinedValue extends Value {

	@SuppressWarnings("unchecked")
	public UndefinedValue() {
		super(null);
	}
	
	@Override
	public boolean isUndefined() {
		return true;
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
		return argument.orBoolean(false);
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
		return argument.andBoolean(false);
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
		return new BooleanValue(argument);
		
	}

	@Override
	public Value notEqualToBoolean(boolean argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value notEqualToInteger(int argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value notEqualToFloat(float argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value notEqualToString(String argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value lowerThanInteger(int argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value lowerThanFloat(float argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value lowerOrEqualInteger(int argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value lowerOrEqualFloat(float argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value greaterThanInteger(int argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value greaterThanFloat(float argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value greaterOrEqualThanInteger(int argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value greaterOrEqualThanFloat(float argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value equalToBoolean(boolean argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value equalToInteger(int argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value equalToFloat(float argument) {
		return new BooleanValue(false);
		
	}

	@Override
	public Value equalToString(String argument) {
		return new BooleanValue(false);
	}

	@Override
	public Value andBoolean(boolean argument) {
		return new BooleanValue(false);
	}

}
