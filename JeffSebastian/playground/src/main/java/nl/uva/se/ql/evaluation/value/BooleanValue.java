package nl.uva.se.ql.evaluation.value;

public class BooleanValue extends Value<Boolean> {

	public BooleanValue(Boolean value) {
		super(value);
	}

	@Override
	public Value and(Value value) {
		return value.andBoolean(this);
	}
	
	@Override
	public BooleanValue andBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() && getValue());
	}

	@Override
	public Value equal(Value value) {
		return value.equalBoolean(this);
	}
	
	@Override
	public BooleanValue equalBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue().equals(getValue()));
	}

	@Override
	public BooleanValue not() {
		return notBoolean();
	}
	
	@Override
	public BooleanValue notBoolean() {
		return new BooleanValue(!(getValue()));
	}

	@Override
	public Value notEqual(Value value) {
		return value.notEqualBoolean(this);
	}
	
	@Override
	public BooleanValue notEqualBoolean(BooleanValue value) {
		return new BooleanValue(!(value.getValue().equals(getValue())));
	}

	@Override
	public BooleanValue or(Value value) {
		return orBoolean(this);
	}
	
	@Override
	public BooleanValue orBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() || getValue());
	}

}
