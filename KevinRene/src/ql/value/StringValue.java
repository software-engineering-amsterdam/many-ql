package ql.value;

import ql.Value;
import ql.ast.QLType;
import ql.ast.type.QLString;

public class StringValue implements Value {
	private final String value;
	
	@Override
	public boolean isUndefined() {
		return false;
	}

	@Override
	public boolean isNumeric() {
		return false;
	}
	
	public StringValue(String value) {
		this.value = value;
	}

	@Override
	public String getPrimitive() {
		return value;
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public Value add(Value argument) {
		throw new UnsupportedOperationException("Cannot add strings.");
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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException("Cannot negate a StringValue.");
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
	public Value orBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value notEqualTo(Value argument) {
		return argument.notEqualToString(this);
	}

	@Override
	public Value notEqualToBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
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
		return new BooleanValue(!argument.equals(this));
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
		return argument.equalToString(this);
	}

	@Override
	public Value equalToBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
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
		return new BooleanValue(argument.equals(this));
	}

	@Override
	public Value and(Value argument) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value andBoolean(BooleanValue argument) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof StringValue) {
			return getPrimitive().equals(((StringValue) obj).getPrimitive());
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "\"" + getPrimitive() + "\"";
	}
}
