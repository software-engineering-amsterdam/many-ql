package org.uva.sea.ql.encoders.ast.type;

public class QLString extends DataType<String> {

	public QLString(String value) {
		super(value);
	}

	@Override
	public DataType<String> add(DataType<String> leftValue, DataType<String> rightValue) {
		String value = leftValue.getValue() + rightValue.getValue();
		return new QLString(value);
	}

	@Override
	public <C> C accept(DataTypeVisitor<C> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}
}
