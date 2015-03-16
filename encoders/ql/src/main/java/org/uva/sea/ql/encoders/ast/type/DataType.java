package org.uva.sea.ql.encoders.ast.type;

import org.uva.sea.ql.encoders.ast.AstNode;

public abstract class DataType implements AstNode {

	private static final String NOT_SUPPORTED_OPERATION = "Not supported operation";

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	public abstract String getName();

	@Override
	public String toString() {
		return getName().toString();
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DataType)) {
			return false;
		}
		if (!getName().equals(((DataType) obj).getName())) {
			return false;
		}
		return true;
	}

}
