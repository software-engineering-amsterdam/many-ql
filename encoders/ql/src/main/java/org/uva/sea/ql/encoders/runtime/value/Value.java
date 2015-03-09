package org.uva.sea.ql.encoders.runtime.value;

import org.uva.sea.ql.encoders.ast.type.DataTypeVisitor;

public abstract class Value {

	private static final String NOT_SUPPORTED_OPERATION = "Not supported operation";

	public Value multiply(Value otherValue) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}

	public Value divide(Value otherValue) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}

	public Value add(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value substract(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value and(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value or(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value lessThan(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value greaterThan(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value lessOrEqual(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value greaterOrEqual(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value equal(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value notEqual(Value otherValue) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public Value not(Value value) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

}
