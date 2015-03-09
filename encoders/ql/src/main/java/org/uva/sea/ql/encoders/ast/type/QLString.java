package org.uva.sea.ql.encoders.ast.type;

public class QLString extends DataType {

	@Override
	public <V> V add(V leftValue, V rightValue) {
		String result = (String) leftValue + (String) rightValue;
		return (V) result;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}
}
