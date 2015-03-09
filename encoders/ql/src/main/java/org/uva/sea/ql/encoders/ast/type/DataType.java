package org.uva.sea.ql.encoders.ast.type;

public abstract class DataType<V> {

	public V add(V leftValue, V rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public V and(V leftValue, V rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public V mul(V leftValue, V rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException("Not supported operation");
	}
}
