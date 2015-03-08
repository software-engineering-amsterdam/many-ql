package org.uva.sea.ql.encoders.ast.type;

public class QLBoolean extends DataType {

	private Boolean value;

	public QLBoolean(Boolean value) {
		this.value = value;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	public Boolean getValue() {
		return value;
	}
}
