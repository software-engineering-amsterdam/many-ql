package org.uva.sea.ql.encoders.ast.type;

public abstract class DataType {

	private static final String NOT_SUPPORTED_OPERATION = "Not supported operation";

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

}
