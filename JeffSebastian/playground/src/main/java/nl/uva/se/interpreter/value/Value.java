package nl.uva.se.interpreter.value;

public abstract class Value<T> {

	private T value;

	public Value(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	public boolean isUndefined() {
		return false;
	}

	public Value add(Value value) {
		throw new IllegalStateException();
	}
	
	public Value div(Value value) {
		throw new IllegalStateException();
	}
	
	public Value mod(Value value) {
		throw new IllegalStateException();
	}
	
	public Value mult(Value value) {
		throw new IllegalStateException();
	}
	
	public Value neg() {
		throw new IllegalStateException();
	}
	
	public Value pos() {
		throw new IllegalStateException();
	}
	
	public Value pow(Value value) {
		throw new IllegalStateException();
	}
	
	public Value sub(Value value) {
		throw new IllegalStateException();
	}
	
	public Value and(Value value) {
		throw new IllegalStateException();
	}
	
	public Value equal(Value value) {
		throw new IllegalStateException();
	}
	
	public Value greaterOrEqual(Value value) {
		throw new IllegalStateException();
	}
	
	public Value greaterThen(Value value) {
		throw new IllegalStateException();
	}
	
	public Value lessOrEqual(Value value) {
		throw new IllegalStateException();
	}
	
	public Value lessThen(Value value) {
		throw new IllegalStateException();
	}
	
	public Value not() {
		throw new IllegalStateException();
	}
	
	public Value notEqual(Value value) {
		throw new IllegalStateException();
	}
	
	public Value or(Value value) {
		throw new IllegalStateException();
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
