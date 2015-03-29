package nl.uva.sc.encoders.ql.ast.type;

import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;


public class BooleanType extends DataType {

	private static final String name = "boolean";

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

	@Override
	public String getName() {
		return name;
	}

}
