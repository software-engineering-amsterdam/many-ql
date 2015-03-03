package cons;


@SuppressWarnings("rawtypes")
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
	public abstract Value add(Value argument);
	public abstract Value addInteger(int argument);
	public abstract Value addFloat(float argument);
	public abstract Value addString(String argument);
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value divide(Value argument);
	public abstract Value divideInteger(int argument);
	public abstract Value divideFloat(float argument);
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value multiply(Value argument);
	public abstract Value multiplyInteger(int argument);	
	public abstract Value multiplyFloat(float argument);
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public abstract Value subtract(Value argument);
	public abstract Value subtractInteger(int argument);
	public abstract Value subtractFloat(float argument);
	
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
	 * @param argument
	 * @return
	 */
	public abstract Value or(Value argument);
	public abstract Value orBoolean(boolean argument);
	
	public abstract Value notEqualTo(Value argument);
	public abstract Value notEqualToBoolean(boolean argument);
	public abstract Value notEqualToInteger(int argument);
	public abstract Value notEqualToFloat(float argument);
	public abstract Value notEqualToString(String argument);
	
	public abstract Value lowerThan(Value argument);
	public abstract Value lowerThanInteger(int argument);
	public abstract Value lowerThanFloat(float argument);
	
	public abstract Value lowerOrEqual(Value argument);
	public abstract Value lowerOrEqualInteger(int argument);
	public abstract Value lowerOrEqualFloat(float argument);
	
	public abstract Value greaterThan(Value argument);
	public abstract Value greaterThanInteger(int argument);
	public abstract Value greaterThanFloat(float argument);
	
	public abstract Value greaterOrEqual(Value argument);
	public abstract Value greaterOrEqualThanInteger(int argument);
	public abstract Value greaterOrEqualThanFloat(float argument);
	
	public abstract Value equalTo(Value argument);
	public abstract Value equalToBoolean(boolean argument);
	public abstract Value equalToInteger(int argument);
	public abstract Value equalToFloat(float argument);
	public abstract Value equalToString(String argument);
	
	public abstract Value and(Value argument);
	public abstract Value andBoolean(boolean argument);
	
	@Override
	public boolean equals(Object obj) {		
		if(obj instanceof Value) {
			return ((Value) obj).getValue().equals(this.value);
		}
		
		return false;
	};
	
	@Override
	public String toString() {
		return value.toString();
	}
}
