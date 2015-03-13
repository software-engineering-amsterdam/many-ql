package nl.uva.se.ql.evaluation.value;

public class BooleanValue extends Value<Boolean> {

	public BooleanValue(Boolean value) {
		super(value);
	}

	@Override
	public Value and(Value value) {
		return new BooleanValue(getBool(value) && this.getValue());
	}

	@Override
	public Value equal(Value value) {
		return new BooleanValue(getBool(value).equals(this.getValue()));
	}

	@Override
	public Value not() {
		return new BooleanValue(!(this.getValue()));
	}

	@Override
	public Value notEqual(Value value) {
		return new BooleanValue(!(getBool(value).equals(this.getValue())));
	}

	@Override
	public Value or(Value value) {
		return new BooleanValue(getBool(value) || this.getValue());
	}
	
	private Boolean getBool(Value value) {
		BooleanValue boolVal = (BooleanValue) value;
		return boolVal.getValue();
	}
}
