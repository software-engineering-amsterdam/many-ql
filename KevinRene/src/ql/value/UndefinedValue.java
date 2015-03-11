package ql.value;

import ql.Value;

public class UndefinedValue extends Value<Void> {
	public UndefinedValue() {
		super(null);
	}
	
	@Override
	public boolean isUndefined() {
		return true;
	}

	@Override
	public Value<Void> add(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> divide(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> multiply(Value<?> argument) {
		return this;
	}
	
	@Override
	public Value<Void> subtract(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> not() {
		return this;
	}

	@Override
	public Value<Void> positive() {
		return this;
	}

	@Override
	public Value<Void> negative() {
		return this;
	}

	@Override
	public Value<?> or(Value<?> argument) {
		return argument.orBoolean(false);
	}

	@Override
	public Value<Void> notEqualTo(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> lowerThan(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> lowerOrEqual(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> greaterThan(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> greaterOrEqual(Value<?> argument) {
		return this;
	}

	@Override
	public Value<Void> equalTo(Value<?> argument) {
		return this;
	}

	@Override
	public Value<?> and(Value<?> argument) {
		return argument.andBoolean(false);
	}

	@Override
	public Value<Void> addInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> addFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> addString(String argument) {
		return this;
	}

	@Override
	public Value<Void> divideInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> divideFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> multiplyInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> multiplyFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> subtractInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> subtractFloat(float argument) {
		return this;
	}

	@Override
	public Value<Boolean> orBoolean(boolean argument) {
		return new BooleanValue(argument);
		
	}

	@Override
	public Value<Void> notEqualToBoolean(boolean argument) {
		return this;
	}

	@Override
	public Value<Void> notEqualToInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> notEqualToFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> notEqualToString(String argument) {
		return this;
	}

	@Override
	public Value<Void> lowerThanInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> lowerThanFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> lowerOrEqualInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> lowerOrEqualFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> greaterThanInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> greaterThanFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> greaterOrEqualThanInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> greaterOrEqualThanFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> equalToBoolean(boolean argument) {
		return this;
	}

	@Override
	public Value<Void> equalToInteger(int argument) {
		return this;
	}

	@Override
	public Value<Void> equalToFloat(float argument) {
		return this;
	}

	@Override
	public Value<Void> equalToString(String argument) {
		return this;
	}

	@Override
	public Value<Boolean> andBoolean(boolean argument) {
		return new BooleanValue(false);
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
