package nl.uva.sc.encoders.ql.ast.type;

import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;


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
