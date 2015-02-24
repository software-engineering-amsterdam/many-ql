package interpreter;

public class IntegerValue extends Value  {
	private final Integer integerValue;
	
	public IntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}
	
	public Integer getIntegerValue() {
		return integerValue;
	}
	
	
	public Value add(Value value) {
		return value.addInt(this); 
	}

	public Value substract(Value value) {
		return value.substractInt(this); 
	}

	public Value multiply(Value value) {
		return value.multiplyInt(this); 
	}

	public Value divide(Value value) {
		return value.divideInt(this); 
	}

	public Value equality(Value value) {
		return value.equalityInt(this);
	}

	public Value greaterEqual(Value value) {
		return value.greaterEqualInt(this);
	}

	public Value greater(Value value) {
		return value.greaterInt(this);
	}

	public Value lessEqual(Value value) {
		return value.lessEqualInt(this);
	}

	public Value less(Value value) {
		return value.lessInt(this);
	}

	public Value notEqual(Value value) {
		return value.notEqualInt(this);
	}

	public Value plus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Value minus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Value addInt(IntegerValue value) {
		return new IntegerValue(value.getIntegerValue() + getIntegerValue());
	}

	public Value substractInt(IntegerValue value) {
		return new IntegerValue(value.getIntegerValue() - getIntegerValue());
	}

	public Value multiplyInt(IntegerValue value) {
		return new IntegerValue(value.getIntegerValue() * getIntegerValue());
	}

	public Value divideInt(IntegerValue value) {
		return new IntegerValue(value.getIntegerValue() / getIntegerValue());
	}

	public Value equalityInt(IntegerValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Value greaterEqualInt(IntegerValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Value greaterInt(IntegerValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Value lessEqualInt(IntegerValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Value lessInt(IntegerValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Value notEqualInt(IntegerValue value) {
		// TODO Auto-generated method stub
		return null;
	}

 // TODO hashmap stuff...
}
