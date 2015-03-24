package nl.uva.sc.encoders.ql.ast.type;

import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;

public abstract class DataType {

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
