package org.uva.sea.ql.encoders.ast.type;

public class BooleanType extends DataType {

	private final String name;

	public BooleanType(String name) {
		this.name = name;
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public String getName() {
		return name;
	}

}
