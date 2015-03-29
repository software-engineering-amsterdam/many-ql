package ql;

import ql.ast.QLType;
import ql.value.BooleanValue;
import ql.value.FloatValue;
import ql.value.IntegerValue;
import ql.value.StringValue;


public interface Value {	
	public boolean isUndefined();
	
	public boolean isNumeric();
	
	public Object getPrimitive();
	public QLType getType();
	
	/**
	 * Addition
	 * 
	 * @param argument
	 * @return
	 */	
	public Value add(Value argument);
	public Value addInteger(IntegerValue argument);
	public Value addFloat(FloatValue argument);
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public Value divide(Value argument);
	public Value divideInteger(IntegerValue argument);
	public Value divideFloat(FloatValue argument);
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public Value multiply(Value argument);
	public Value multiplyInteger(IntegerValue argument);	
	public Value multiplyFloat(FloatValue argument);
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public Value subtract(Value argument);
	public Value subtractInteger(IntegerValue argument);
	public Value subtractFloat(FloatValue argument);
	
	/**
	 * Unary
	 * 
	 * @return
	 */
	public Value not();
	public Value positive();
	public Value negative();
	
	/**
	 * Relational
	 * @param rightValue
	 * @return
	 */
	public Value or(Value rightValue);
	public Value orBoolean(BooleanValue argument);
	
	public Value notEqualTo(Value argument);
	public Value notEqualToBoolean(BooleanValue argument);
	public Value notEqualToInteger(IntegerValue argument);
	public Value notEqualToFloat(FloatValue argument);
	public Value notEqualToString(StringValue argument);
	
	public Value lowerThan(Value argument);
	public Value lowerThanInteger(IntegerValue argument);
	public Value lowerThanFloat(FloatValue argument);
	
	public Value lowerOrEqual(Value argument);
	public Value lowerOrEqualInteger(IntegerValue argument);
	public Value lowerOrEqualFloat(FloatValue argument);
	
	public Value greaterThan(Value argument);
	public Value greaterThanInteger(IntegerValue argument);
	public Value greaterThanFloat(FloatValue argument);
	
	public Value greaterOrEqual(Value argument);
	public Value greaterOrEqualThanInteger(IntegerValue argument);
	public Value greaterOrEqualThanFloat(FloatValue argument);
	
	public Value equalTo(Value argument);
	public Value equalToBoolean(BooleanValue argument);
	public Value equalToInteger(IntegerValue argument);
	public Value equalToFloat(FloatValue argument);
	public Value equalToString(StringValue argument);
	
	public Value and(Value argument);
	public Value andBoolean(BooleanValue argument);
	
	@Override
	public int hashCode();
	@Override
	public boolean equals(Object obj);
	@Override
	public String toString();
}
