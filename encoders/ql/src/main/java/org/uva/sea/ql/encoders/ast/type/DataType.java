package org.uva.sea.ql.encoders.ast.type;

public abstract class DataType<V> {

	private static final String NOT_SUPPORTED_OPERATION = "Not supported operation";

	public V multiply(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V divide(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V add(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V substract(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V and(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V or(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V lessThan(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V greaterThan(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V lessOrEqual(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V greaterOrEqual(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V equal(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V notEqual(V leftValue, V rightValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public V not(V value) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

}
