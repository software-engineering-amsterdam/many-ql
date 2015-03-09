package org.uva.sea.ql.encoders.ast.type;

public class StringType extends DataType<String> {

	@Override
	public String add(String leftValue, String rightValue) {
		String result = leftValue + rightValue;
		return result;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}
}
