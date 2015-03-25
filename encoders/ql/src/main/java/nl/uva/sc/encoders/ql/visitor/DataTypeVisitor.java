package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;

public interface DataTypeVisitor<T> {

	T visit(BooleanType qlBoolean);

	T visit(IntegerType qlInteger);

	T visit(StringType qlString);
}
