package ql;

import ql.value.BooleanValue;
import ql.value.FloatValue;
import ql.value.IntegerValue;
import ql.value.StringValue;


public abstract class Value {	
	public boolean isUndefined() {
		return false;
	}
	
	public boolean isNumeric() {
		return false;
	}
	
	/**
	 * Addition
	 * 
	 * @param argument
	 * @return
	 */	
	public abstract Value add(Value argument);
	public abstract Value addInteger(IntegerValue argument);
	public abstract Value addFloat(FloatValue argument);
	public abstract Value addString(StringValue argument);
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value divide(Value argument);
	public abstract Value divideInteger(IntegerValue argument);
	public abstract Value divideFloat(FloatValue argument);
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value multiply(Value argument);
	public abstract Value multiplyInteger(IntegerValue argument);	
	public abstract Value multiplyFloat(FloatValue argument);
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value subtract(Value argument);
	public abstract Value subtractInteger(IntegerValue argument);
	public abstract Value subtractFloat(FloatValue argument);
	
	/**
	 * Unary
	 * 
	 * @return
	 */
	public abstract Value not();
	public abstract Value positive();
	public abstract Value negative();
	
	/**
	 * Relational
	 * @param rightValue
	 * @return
	 */
	public abstract Value or(Value rightValue);
	public abstract Value orBoolean(BooleanValue argument);
	
	public abstract Value notEqualTo(Value argument);
	public abstract Value notEqualToBoolean(BooleanValue argument);
	public abstract Value notEqualToInteger(IntegerValue argument);
	public abstract Value notEqualToFloat(FloatValue argument);
	public abstract Value notEqualToString(StringValue argument);
	
	public abstract Value lowerThan(Value argument);
	public abstract Value lowerThanInteger(IntegerValue argument);
	public abstract Value lowerThanFloat(FloatValue argument);
	
	public abstract Value lowerOrEqual(Value argument);
	public abstract Value lowerOrEqualInteger(IntegerValue argument);
	public abstract Value lowerOrEqualFloat(FloatValue argument);
	
	public abstract Value greaterThan(Value argument);
	public abstract Value greaterThanInteger(IntegerValue argument);
	public abstract Value greaterThanFloat(FloatValue argument);
	
	public abstract Value greaterOrEqual(Value argument);
	public abstract Value greaterOrEqualThanInteger(IntegerValue argument);
	public abstract Value greaterOrEqualThanFloat(FloatValue argument);
	
	public abstract Value equalTo(Value argument);
	public abstract Value equalToBoolean(BooleanValue argument);
	public abstract Value equalToInteger(IntegerValue argument);
	public abstract Value equalToFloat(FloatValue argument);
	public abstract Value equalToString(StringValue argument);
	
	public abstract Value and(Value argument);
	public abstract Value andBoolean(BooleanValue argument);
	
	@Override
	public abstract int hashCode();
	@Override
	public abstract boolean equals(Object obj);
	@Override
	public abstract String toString();
}
