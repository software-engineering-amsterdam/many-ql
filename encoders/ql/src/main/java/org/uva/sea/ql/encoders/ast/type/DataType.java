package org.uva.sea.ql.encoders.ast.type;

public abstract class DataType {

	public <V> V add(V leftValue, V rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public <V> V and(V leftValue, V rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public <V> V mul(V leftValue, V rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException("Not supported operation");
	}
}
