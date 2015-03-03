package interpreter;

public class IntegerValue extends Value<Integer>  {
//	private final Integer integerValue;
	
	public IntegerValue(Integer integerValue) {
		super(integerValue);
		//this.integerValue = integerValue;
	}
	/*
	public Integer getIntegerValue() {
		return integerValue;
	}
	*/
	
	
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
		// TODO to be tested (for minus too).
		return new IntegerValue(getValue());
	}

	public Value minus() {
		return new IntegerValue(-getValue());
	}

	public Value addInt(IntegerValue value) {
		return new IntegerValue(value.getValue() + getValue());
	}

	public Value substractInt(IntegerValue value) {
		return new IntegerValue(value.getValue() - getValue());
	}

	public Value multiplyInt(IntegerValue value) {
		return new IntegerValue(value.getValue() * getValue());
	}

	public Value divideInt(IntegerValue value) {
		return new IntegerValue(value.getValue() / getValue());
	}

	public Value equalityInt(IntegerValue value) {
		return new BooleanValue(value.getValue() == getValue());
	}

	public Value greaterEqualInt(IntegerValue value) {
		return new BooleanValue(value.getValue() >= getValue());
	}

	public Value greaterInt(IntegerValue value) {
		return new BooleanValue(value.getValue() > getValue());
	}

	public Value lessEqualInt(IntegerValue value) {
		return new BooleanValue(value.getValue() <= getValue());
	}

	public Value lessInt(IntegerValue value) {
		return new BooleanValue(value.getValue() < getValue());
	}

	public Value notEqualInt(IntegerValue value) {
		return new BooleanValue(value.getValue() != getValue());
	}
/*
	public boolean equals(Object object) {
		if (object instanceof IntegerValue) {	
			return getValue().equals(((IntegerValue) object).getValue());
		}
		return false;
	}
	*/	
}
