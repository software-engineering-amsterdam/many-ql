package interpreter;

public class BooleanValue extends Value {
	private final Boolean booleanValue;
	
	public BooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	
	public Boolean getBooleanValue() {
		return booleanValue;
	}
	
	public Value and(Value value) {
		return value.andBoolean(this);
	}

	public Value or(Value value) {
		return value.orBoolean(this);
	} 
	
	public Value not() {
		return new BooleanValue(!getBooleanValue());
	}
	
	public Value equality(Value value) {
		return value.equalBoolean(this);
	}
	
	
	public Value equalBoolean(BooleanValue value) {
		return new BooleanValue(value.getBooleanValue() == getBooleanValue() );
	}

	public Value andBoolean(BooleanValue value) {
		return new BooleanValue(value.getBooleanValue() && getBooleanValue() );
	}
	
	public Value orBoolean(BooleanValue value) {
		return new BooleanValue(value.getBooleanValue() || getBooleanValue() );
	}
	
	// TODO: hashmap / equals stuff
	
}
