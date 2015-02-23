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
	
}
