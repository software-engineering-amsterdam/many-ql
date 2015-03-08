package org.uva.sea.ql.encoders.ast.type;

public class QLInteger extends DataType<Integer> {

	public QLInteger(Integer value) {
		super(value);
	}

	@Override
	public DataType<Integer> add(DataType<Integer> leftValue, DataType<Integer> rightValue) {
		int value = leftValue.getValue() + rightValue.getValue();
		return new QLInteger(value);
	}

	@Override
	public <C> C accept(DataTypeVisitor<C> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}
}
