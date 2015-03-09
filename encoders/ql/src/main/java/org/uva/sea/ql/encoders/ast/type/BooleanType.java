package org.uva.sea.ql.encoders.ast.type;

public class BooleanType extends DataType<Boolean> {

	public static final BooleanType BOOLEAN = new BooleanType();

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public Boolean and(Boolean leftValue, Boolean rightValue) {
		Boolean result = leftValue && rightValue;
		return result;
	}

	@Override
	public Boolean not(Boolean value) {
		return !value;
	}

}
