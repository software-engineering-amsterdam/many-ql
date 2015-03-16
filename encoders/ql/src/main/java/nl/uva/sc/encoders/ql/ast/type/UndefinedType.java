package nl.uva.sc.encoders.ql.ast.type;

import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;

public class UndefinedType extends DataType {

	private static final String NOT_SUPPORTED_OPERATION = "Not supported operation";

	public static final UndefinedType UNDEFINED = new UndefinedType();

	@Override
	public String getName() {
		return "undefined";
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

}
