package nl.uva.sc.encoders.ql.ast.type;

import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;

public class UndefinedType extends DataType {

	public static final UndefinedType UNDEFINED = new UndefinedType();

	@Override
	public String getName() {
		return "undefined";
	}

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new UnsupportedOperationException();
	}

}
