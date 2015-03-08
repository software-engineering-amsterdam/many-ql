package org.uva.sea.ql.encoders.ast.type;

public abstract class DataType {

	public <T extends DataType> T add(T rightValue) {
		throw new IllegalStateException("Not supported operation");
	}

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException("Not supported operation");
	}
}
