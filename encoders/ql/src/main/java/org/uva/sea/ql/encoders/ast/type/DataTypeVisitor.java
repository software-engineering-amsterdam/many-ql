package org.uva.sea.ql.encoders.ast.type;

public interface DataTypeVisitor<T> {

	T visit(BooleanType qlBoolean);

	T visit(IntegerType qlInteger);

	T visit(StringType qlString);
}
