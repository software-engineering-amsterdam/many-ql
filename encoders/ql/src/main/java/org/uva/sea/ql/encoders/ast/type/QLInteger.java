package org.uva.sea.ql.encoders.ast.type;

public class QLInteger extends DataType {

	private Integer value;

	public QLInteger(Integer value) {
		this.value = value;
	}

	@Override
	public <T extends DataType> T add(T rightValue) {
		int result = value + ((QLInteger) rightValue).getValue();
		return (T) new QLInteger(result);
	}

	@Override
	public <C> C accept(DataTypeVisitor<C> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	public Integer getValue() {
		return value;
	}
}
