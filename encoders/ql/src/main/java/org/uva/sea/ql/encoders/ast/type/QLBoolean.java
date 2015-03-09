package org.uva.sea.ql.encoders.ast.type;

public class QLBoolean extends DataType<Boolean> {

	public static final QLBoolean BOOLEAN = new QLBoolean();

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public Boolean and(Boolean leftValue, Boolean rightValue) {
		Boolean result = leftValue && rightValue;
		return result;
	}

}
