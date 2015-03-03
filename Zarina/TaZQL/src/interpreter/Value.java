package interpreter;

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

	public Value add(Value value)
		{ throw new UnsupportedOperationException("Not supported in add()."); }
	
	public Value substract(Value value) 
		{ throw new UnsupportedOperationException("Not supported in substract()."); }
	
	public Value multiply(Value value) 
		{ throw new UnsupportedOperationException("Not supported in multiply()."); }
	
	public Value divide(Value value) 
		{ throw new UnsupportedOperationException("Not supported in divide()."); }
	
	
	
	public Value equality(Value value) 
		{ throw new UnsupportedOperationException("Not supported in equality()."); }
	
	public Value greaterEqual(Value value) 
		{ throw new UnsupportedOperationException("Not supported in greaterEqual()."); }
	
	public Value greater(Value value) 
		{ throw new UnsupportedOperationException("Not supported in greater()."); }
	
	public Value lessEqual(Value value) 
		{ throw new UnsupportedOperationException("Not supported lessEqual()."); }
	
	public Value less(Value value) 
		{ throw new UnsupportedOperationException("Not supported in less()."); }
	
	public Value notEqual(Value value) 
		{ throw new UnsupportedOperationException("Not supported in notEqual()."); }
	
	public Value and(Value value) 
		{ throw new UnsupportedOperationException("Not supported in and()."); }
	
	public Value or(Value value) 
		{ throw new UnsupportedOperationException("Not supported in or()."); }
	
	public Value not() 
		{ throw new UnsupportedOperationException("Not supported in not()."); }
	
	public Value plus() 
		{ throw new UnsupportedOperationException("Not supported in plus()."); }
	
	public Value minus() 
		{ throw new UnsupportedOperationException("Not supported in minus()."); }
	
	
	// *** double dispatch to the rescue ***
	
	public Value addInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in addInt()."); }
	
	public Value substractInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in substractInt()."); }
	
	public Value multiplyInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in multiplyInt()."); }
	
	public Value divideInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in divideInt()."); }
	
	public Value equalityInt(IntegerValue value) 
		{throw new UnsupportedOperationException("Not supported in equalityInt()."); }
	
	public Value greaterEqualInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in greaterEqualInt()."); }
		
	public Value greaterInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in greaterInt()."); }
	
	public Value lessEqualInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in lessEqualInt()."); }
	
	public Value lessInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in lessInt()."); }
	
	public Value notEqualInt(IntegerValue value) 
		{ throw new UnsupportedOperationException("Not supported in notEqualInt()."); }
	
	public Value andBoolean(BooleanValue value) 
		{ throw new UnsupportedOperationException("Not supported in andBoolean()."); }
	
	public Value orBoolean(BooleanValue value) 
		{ throw new UnsupportedOperationException("Not supported in orBoolean()."); }
	
	public Value equalBoolean(BooleanValue value) 
		{ throw new UnsupportedOperationException("Not supported in equalBoolean()."); }	
}
