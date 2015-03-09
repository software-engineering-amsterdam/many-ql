package org.uva.sea.ql.encoders.ast.type;

public class QLInteger extends DataType<Integer> {

	@Override
	public Integer add(Integer leftValue, Integer rightValue) {
		Integer result = leftValue + rightValue;
		return result;
	}

	@Override
	public Integer multiply(Integer leftValue, Integer rightValue) {
		Integer result = leftValue * rightValue;
		return result;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

}
