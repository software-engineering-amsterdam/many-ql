package org.uva.sea.ql.encoders.ast.type;


public interface DataTypeVisitor<T> {

	T visit(QLBoolean qlBoolean);

	T visit(QLInteger qlInteger);

	T visit(QLString qlString);
}
