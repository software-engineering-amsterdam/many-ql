package nl.uva.se.ql.evaluation.value;

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
	
	public Value promote() {
		return this;
	}

	public Value add(Value value) {
		throw new IllegalStateException();
	}
	
	public Value addInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value addDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value addString(StringValue value) {
		throw new IllegalStateException();
	}
	
	public Value div(Value value) {
		throw new IllegalStateException();
	}
	
	public Value divInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value divDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value mod(Value value) {
		throw new IllegalStateException();
	}
	
	public Value modInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value modDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value mult(Value value) {
		throw new IllegalStateException();
	}
	
	public Value multInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value multDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value neg() {
		throw new IllegalStateException();
	}
	
	public Value negInteger() {
		throw new IllegalStateException();
	}
	
	public Value negDecimal() {
		throw new IllegalStateException();
	}
	
	public Value pos() {
		throw new IllegalStateException();
	}
	
	public Value posInteger() {
		throw new IllegalStateException();
	}
	
	public Value posDecimal() {
		throw new IllegalStateException();
	}
	
	public Value pow(Value value) {
		throw new IllegalStateException();
	}
	
	public Value powInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value powDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value sub(Value value) {
		throw new IllegalStateException();
	}
	
	public Value subInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value subDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value and(Value value) {
		throw new IllegalStateException();
	}
	
	public Value andBoolean(BooleanValue value) {
		throw new IllegalStateException();
	}
	
	public Value equal(Value value) {
		throw new IllegalStateException();
	}
	
	public Value equalBoolean(BooleanValue value) {
		throw new IllegalStateException();
	}
	
	public Value equalInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value equalDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value equalString(StringValue value) {
		throw new IllegalStateException();
	}
	
	public Value greaterOrEqual(Value value) {
		throw new IllegalStateException();
	}
	
	public Value greaterOrEqualInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value greaterOrEqualDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value greaterThan(Value value) {
		throw new IllegalStateException();
	}
	
	public Value greaterThanInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value greaterThanDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value lessOrEqual(Value value) {
		throw new IllegalStateException();
	}
	
	public Value lessOrEqualInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value lessOrEqualDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value lessThan(Value value) {
		throw new IllegalStateException();
	}
	
	public Value lessThanInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value lessThanDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value not() {
		throw new IllegalStateException();
	}
	
	public Value notBoolean() {
		throw new IllegalStateException();
	}
	
	public Value notEqual(Value value) {
		throw new IllegalStateException();
	}
	
	public Value notEqualInteger(IntegerValue value) {
		throw new IllegalStateException();
	}
	
	public Value notEqualDecimal(DecimalValue value) {
		throw new IllegalStateException();
	}
	
	public Value notEqualBoolean(BooleanValue value) {
		throw new IllegalStateException();
	}
	
	public Value notEqualString(StringValue value) {
		throw new IllegalStateException();
	}
	
	public Value or(Value value) {
		throw new IllegalStateException();
	}
	
	public Value orBoolean(BooleanValue value) {
		throw new IllegalStateException();
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
