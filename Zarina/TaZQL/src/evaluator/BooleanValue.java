package evaluator;

public class BooleanValue extends Value<Boolean> {
	
	public BooleanValue(boolean booleanValue) {
		super(booleanValue);
	}

	public Value and(Value value) {
		return value.andBoolean(this);
	}

	public Value or(Value value) {
		return value.orBoolean(this);
	} 
	
	public Value not() {
		return new BooleanValue(!getValue());
	}
	
	public Value equality(Value value) {
		return value.equalBoolean(this);
	}
	
	
	public Value equalBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() == getValue() );
	}

	public Value andBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() && getValue() );
	}
	
	public Value orBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() || getValue() );
	}
}
