package org.uva.sea.ql.encoders.ast.type;


public class DataType<T> {

	private T value;

	public DataType() {
		value = null;
	}

	public DataType(T value) {
		this.value = value;
	}

	public DataType<T> add(DataType<T> leftValue, DataType<T> rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public T getValue() {
		return value;
	}

	public <C> C accept(DataTypeVisitor<C> dataTypeVisitor) {
		throw new IllegalStateException("Not supported operation");
	}
}
