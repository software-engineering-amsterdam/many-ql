package evaluator;

public abstract class Value<T> {
	private final T value;
	
	public Value(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public String toString() {
		return value.toString();
	}

	public Value add(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in addition operations."); 
	}
	
	public Value substract(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in substaction operations."); 
	}
	
	public Value multiply(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in multiplication operations."); 
	}
	
	public Value divide(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in division operations."); 
	}
	
	
	public Value equality(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in equation operations."); 
	}
	
	public Value greaterEqual(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in (greater or equal) equation operations."); 
	}
	
	public Value greater(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in (greater than) equation operations."); 
	}
	
	public Value lessEqual(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in (less or equal) equation operations."); 
	}
	
	public Value less(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in (less than) equation operations."); 
	}
	
	public Value notEqual(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in (not equal) equation operations."); 
	}
	
	public Value and(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type. Only boolean can be supported in logical operations with *and* operator."); 
	}
	
	public Value or(Value value) { 
		throw new UnsupportedOperationException(
				"Invalid value type. Only boolean can be supported in logical operations with *or* operator."); 
	}
	
	public Value not() { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in logical operations with *not* operator."); 
	}
	
	public Value plus() { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in unary operations with *+* operator."); 
	}
	
	public Value minus() { 
		throw new UnsupportedOperationException(
				"Invalid value type; can't be supported in unary operations with *-* operator."); 
	}
	
	// *** double dispatch to the rescue ***
	
	public Value addInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in addition."); 
	}
	
	public Value substractInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in substraction."); 
	}
	
	public Value multiplyInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in multiplication."); 
	}
	
	public Value divideInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in division."); 
	}
	
	public Value equalityInt(IntegerValue value) {
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in equality operation."); 
	}
	
	public Value greaterEqualInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in equality operation."); 
	}
		
	public Value greaterInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in equality operation."); 
	}
	
	public Value lessEqualInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in equality operation."); 
	}
	
	public Value lessInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in equality operation."); 
	}
	
	public Value notEqualInt(IntegerValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type integer and it can't be supported in equality operation."); 
	}
	
	public Value andBoolean(BooleanValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type boolean and it can't be supported in logical operation."); 
	}
	
	public Value orBoolean(BooleanValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type boolean and it can't be supported in logical operation."); 
	}
	
	public Value equalBoolean(BooleanValue value) { 
		throw new UnsupportedOperationException(
				"Value is not of type boolean and it can't be supported in equality operation."); 
	}	
}
