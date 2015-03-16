package org.uva.sea.ql.encoders.visitor;

import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.ast.type.StringType;

public interface DataTypeVisitor<T> {

	T visit(BooleanType qlBoolean);

	T visit(IntegerType qlInteger);

	T visit(StringType qlString);
}
