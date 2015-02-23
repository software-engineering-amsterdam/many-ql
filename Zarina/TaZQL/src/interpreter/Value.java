package interpreter;

public interface Value {

	public Value add(Value value);
	public Value substract(Value value);
	public Value multiply(Value value);
	public Value divide(Value value);
	
	public Value equality(Value value);
	public Value greaterEqual(Value value);
	public Value greater(Value value);
	public Value lessEqual(Value value);
	public Value less(Value value);
	public Value notEqual(Value value);
	
	public Value and(Value value);
	public Value or(Value value);
	
	public Value not();
	public Value plus();
	public Value minus();
	
	// *** double dispatch to the rescue ***
	
	public Value addInt(IntegerValue value);
	public Value substractInt(IntegerValue value);
	public Value multiplyInt(IntegerValue value);
	public Value divideInt(IntegerValue value);
	
	public Value equalityInt(IntegerValue value);
	public Value greaterEqualInt(IntegerValue value);
	public Value greaterInt(IntegerValue value);
	public Value lessEqualInt(IntegerValue value);
	public Value lessInt(IntegerValue value);
	public Value notEqualInt(IntegerValue value);
	
	public Value andBoolean(BooleanValue value);
	public Value orBoolean(BooleanValue value);
	public Value notBoolean(BooleanValue value);
	
}
