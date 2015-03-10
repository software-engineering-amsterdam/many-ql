package org.uva.sea.ql.encoders.ast.type;

public class UndefinedType extends DataType {

	public static final UndefinedType UNDEFINED = new UndefinedType();

	@Override
	public String getName() {
		return "undefined";
	}

}
