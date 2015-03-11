package ql;


public abstract class Value<T> {
	private T value;
	
	public Value(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
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
	public abstract Value<T> add(Value<?> argument);
	public abstract Value<T> addInteger(int argument);
	public abstract Value<T> addFloat(float argument);
	public abstract Value<T> addString(String argument);
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value<T> divide(Value<?> argument);
	public abstract Value<T> divideInteger(int argument);
	public abstract Value<T> divideFloat(float argument);
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value<T> multiply(Value<?> argument);
	public abstract Value<T> multiplyInteger(int argument);	
	public abstract Value<T> multiplyFloat(float argument);
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value<T> subtract(Value<?> argument);
	public abstract Value<T> subtractInteger(int argument);
	public abstract Value<T> subtractFloat(float argument);
	
	/**
	 * Unary
	 * 
	 * @return
	 */
	public abstract Value<T> not();
	public abstract Value<T> positive();
	public abstract Value<T> negative();
	
	/**
	 * Relational
	 * @param rightValue
	 * @return
	 */
	public abstract Value<T> or(Value<?> rightValue);
	public abstract Value<T> orBoolean(boolean argument);
	
	public abstract Value<T> notEqualTo(Value<?> argument);
	public abstract Value<T> notEqualToBoolean(boolean argument);
	public abstract Value<T> notEqualToInteger(int argument);
	public abstract Value<T> notEqualToFloat(float argument);
	public abstract Value<T> notEqualToString(String argument);
	
	public abstract Value<T> lowerThan(Value<?> argument);
	public abstract Value<T> lowerThanInteger(int argument);
	public abstract Value<T> lowerThanFloat(float argument);
	
	public abstract Value<T> lowerOrEqual(Value<?> argument);
	public abstract Value<T> lowerOrEqualInteger(int argument);
	public abstract Value<T> lowerOrEqualFloat(float argument);
	
	public abstract Value<T> greaterThan(Value<?> argument);
	public abstract Value<T> greaterThanInteger(int argument);
	public abstract Value<T> greaterThanFloat(float argument);
	
	public abstract Value<T> greaterOrEqual(Value<?> argument);
	public abstract Value<T> greaterOrEqualThanInteger(int argument);
	public abstract Value<T> greaterOrEqualThanFloat(float argument);
	
	public abstract Value<T> equalTo(Value<?> argument);
	public abstract Value<Boolean> equalToBoolean(boolean argument);
	public abstract Value<T> equalToInteger(int argument);
	public abstract Value<T> equalToFloat(float argument);
	public abstract Value<T> equalToString(String argument);
	
	public abstract Value<T> and(Value<?> argument);
	public abstract Value<T> andBoolean(boolean argument);
	
	@Override
	public boolean equals(Object obj) {		
		if(obj instanceof Value) {
			return ((Value<?>) obj).getValue().equals(this.value);
		}
		
		return false;
	};
	
	@Override
	public String toString() {
		return value.toString();
	}
}
