package org.uva.sea.ql.encoders.ast.type;

public class StringType extends DataType {

	private static final String name = "string";

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public String getName() {
		return name;
	}

}
