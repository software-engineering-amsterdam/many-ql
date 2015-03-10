package nl.uva.se.ql.evaluation.value;

public class IntegerValue extends Value<Integer> {

	public IntegerValue(int value) {
		super(value);
	}

	@Override
	public Value add(Value value) {
		return new IntegerValue(getValue() + getInteger(value));
	}

	@Override
	public Value div(Value value) {
		return new IntegerValue(getValue() / getInteger(value));
	}

	@Override
	public Value mod(Value value) {
		return new IntegerValue(getValue() % getInteger(value));
	}

	@Override
	public Value mult(Value value) {
		return new IntegerValue(getValue() * getInteger(value));
	}

	@Override
	public Value neg() {
		return new IntegerValue(-getValue());
	}

	@Override
	public Value pos() {
		return new IntegerValue(getValue());
	}

	@Override
	public Value pow(Value value) {
		return new IntegerValue(getValue() ^ getInteger(value));
	}

	@Override
	public Value sub(Value value) {
		return new IntegerValue(getValue() - getInteger(value));
	}

	@Override
	public Value equal(Value value) {
		return new BooleanValue(getValue() == getInteger(value));
	}

	@Override
	public Value greaterOrEqual(Value value) {
		return new BooleanValue(getValue() >= getInteger(value));
	}

	@Override
	public Value greaterThen(Value value) {
		return new BooleanValue(getValue() > getInteger(value));
	}

	@Override
	public Value lessOrEqual(Value value) {
		return new BooleanValue(getValue() <= getInteger(value));
	}

	@Override
	public Value lessThen(Value value) {
		return new BooleanValue(getValue() < getInteger(value));
	}

	@Override
	public Value notEqual(Value value) {
		return new BooleanValue(getValue() != getInteger(value));
	}
	
	private Integer getInteger(Value value) {
		IntegerValue intVal = (IntegerValue) value;
		return intVal.getValue();
	}

}
