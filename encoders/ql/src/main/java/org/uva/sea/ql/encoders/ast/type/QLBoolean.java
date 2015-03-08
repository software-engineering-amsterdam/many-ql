package org.uva.sea.ql.encoders.ast.type;

public class QLBoolean extends DataType {

	private Boolean value;

	public QLBoolean(Boolean value) {
		this.value = value;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public <T extends DataType> T and(T rightValue) {
		boolean result = value && ((QLBoolean) rightValue).getValue();
		System.out.println("!!!" + result + "!!!");
		return (T) new QLBoolean(result);
	}

	public Boolean getValue() {
		return value;
	}
}
