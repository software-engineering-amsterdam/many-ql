package nl.uva.se.ql.evaluation.value;

public class UndefinedValue extends Value<Void> {

	public UndefinedValue() {
		super(null);
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

	@Override
	public Value add(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value div(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value mod(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value mult(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value neg() {
		return new UndefinedValue();
	}

	@Override
	public Value pos() {
		return new UndefinedValue();
	}

	@Override
	public Value pow(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value sub(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value and(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value equal(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value greaterOrEqual(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value greaterThan(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value lessOrEqual(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value lessThan(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value not() {
		return new UndefinedValue();
	}

	@Override
	public Value notEqual(Value value) {
		return new UndefinedValue();
	}

	@Override
	public Value or(Value value) {
		return new UndefinedValue();
	}

	@Override
	public String toString() {
		return "undefined";
	}
	
}
