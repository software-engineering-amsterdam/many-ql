package org.uva.sea.ql.encoders.ast.type;

import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.visitor.DataTypeVisitor;

public abstract class DataType implements AstNode {

	public abstract <T> T accept(DataTypeVisitor<T> dataTypeVisitor);

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
