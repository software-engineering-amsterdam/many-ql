package interpreter;

public class BooleanValue {
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
	// TODO not fixed yet.
	public Value not() 
	{ throw new UnsupportedOperationException("Not supported in not()."); }


	public Value andBoolean(BooleanValue value) {
		return new BooleanValue(value.getBooleanValue() && getBooleanValue() );
	//	throw new UnsupportedOperationException("Not supported in not()."); 
	}
	
	public Value orBoolean(BooleanValue value) {
		throw new UnsupportedOperationException("Not supported in not()."); 
	}
	
	public Value notBoolean(BooleanValue value) 
	{ throw new UnsupportedOperationException("Not supported in notBoolean()."); }	
	
	
}
