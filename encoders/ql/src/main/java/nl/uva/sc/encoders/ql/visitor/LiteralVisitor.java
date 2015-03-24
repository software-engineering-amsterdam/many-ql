package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.literal.StringLiteral;

public interface LiteralVisitor<T> {

	T visit(BooleanLiteral literal);

	T visit(IntegerLiteral literal);

	T visit(StringLiteral literal);
}
