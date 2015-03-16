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
	public Value andBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() && getValue());
	}

	@Override
	public Value equal(Value value) {
		return value.equalBoolean(this);
	}
	
	@Override
	public Value equalBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue().equals(getValue()));
	}

	@Override
	public Value not() {
		return notBoolean();
	}
	
	@Override
	public Value notBoolean() {
		return new BooleanValue(!(getValue()));
	}

	@Override
	public Value notEqual(Value value) {
		return value.notEqualBoolean(this);
	}
	
	@Override
	public Value notEqualBoolean(BooleanValue value) {
		return new BooleanValue(!(value.getValue().equals(getValue())));
	}

	@Override
	public Value or(Value value) {
		return orBoolean(this);
	}
	
	@Override
	public Value orBoolean(BooleanValue value) {
		return new BooleanValue(value.getValue() || getValue());
	}

}
