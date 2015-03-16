package org.uva.sea.ql.encoders.ast.type;


public class IntegerType extends DataType {

	private static final String name = "integer";

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public String getName() {
		return name;
	}

}
