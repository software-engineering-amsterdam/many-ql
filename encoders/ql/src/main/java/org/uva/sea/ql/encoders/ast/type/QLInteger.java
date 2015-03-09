package org.uva.sea.ql.encoders.ast.type;

public class QLInteger extends DataType {

	@Override
	public <V> V add(V leftValue, V rightValue) {
		Integer result = (Integer) leftValue + (Integer) rightValue;
		return (V) result;
	}

	@Override
	public <V> V mul(V leftValue, V rightValue) {
		Integer result = (Integer) leftValue * (Integer) rightValue;
		return (V) result;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

}
