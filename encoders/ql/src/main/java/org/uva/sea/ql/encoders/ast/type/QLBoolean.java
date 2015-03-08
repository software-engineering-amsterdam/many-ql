package org.uva.sea.ql.encoders.ast.type;

public class QLBoolean extends DataType<Boolean> {

	public QLBoolean(Boolean value) {
		super(value);
	}

	@Override
	public <C> C accept(DataTypeVisitor<C> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}
}
