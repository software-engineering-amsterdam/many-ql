package org.uva.sea.ql.encoders.ast.type;

public class QLString extends DataType {

	private String value;

	public QLString(String value) {
		this.value = value;
	}

	@Override
	public <T extends DataType> T add(T rightValue) {
		String result = value + ((QLString) rightValue).getValue();
		return (T) new QLString(result);
	}

	@Override
	public <C> C accept(DataTypeVisitor<C> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	public String getValue() {
		return value;
	}
}
