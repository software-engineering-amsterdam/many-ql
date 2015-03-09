package org.uva.sea.ql.encoders.ast.type;

public class QLBoolean extends DataType {

	public static final QLBoolean BOOLEAN = new QLBoolean();

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public <V> V and(V leftValue, V rightValue) {
		Boolean result = (Boolean) leftValue && (Boolean) rightValue;
		return (V) result;
	}

}
