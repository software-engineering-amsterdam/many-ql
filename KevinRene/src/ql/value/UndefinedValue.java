package ql.value;

import ql.Value;
import ql.ast.QLType;
import ql.ast.type.QLError;

public class UndefinedValue implements Value {
	@Override
	public boolean isUndefined() {
		return true;
	}
	
	@Override
	public boolean isNumeric() {
		return false;
	}

	@Override
	public Void getPrimitive() {
		return null;
	}
	
	@Override
	public QLType getType() {
		return new QLError();
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
		return argument.orBoolean(new BooleanValue(false));
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
		return argument.andBoolean(new BooleanValue(false));
	}

	@Override
	public Value addInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value addFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value divideInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value divideFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value multiplyInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value multiplyFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value subtractInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value subtractFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value orBoolean(BooleanValue argument) {
		return new BooleanValue(argument.getPrimitive());
		
	}

	@Override
	public Value notEqualToBoolean(BooleanValue argument) {
		return this;
	}

	@Override
	public Value notEqualToInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value notEqualToFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value notEqualToString(StringValue argument) {
		return this;
	}

	@Override
	public Value lowerThanInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value lowerThanFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value lowerOrEqualInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value lowerOrEqualFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value greaterThanInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value greaterThanFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value greaterOrEqualThanInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value greaterOrEqualThanFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value equalToBoolean(BooleanValue argument) {
		return this;
	}

	@Override
	public Value equalToInteger(IntegerValue argument) {
		return this;
	}

	@Override
	public Value equalToFloat(FloatValue argument) {
		return this;
	}

	@Override
	public Value equalToString(StringValue argument) {
		return this;
	}

	@Override
	public Value andBoolean(BooleanValue argument) {
		return new BooleanValue(false);
	}
	
	@Override
	public int hashCode() {
		return Boolean.hashCode(false);
	}
	
	@Override
	public boolean equals(Object obj) {		
		if(obj instanceof UndefinedValue) {
			return true;
		}
		
		return false;
	};
	
	@Override
	public String toString() {
		return "Undefined";
	}
}
