package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.StringLiteral;

public interface LiteralVisitor<T> {

	T visit(BooleanLiteral literal);

	T visit(IntegerLiteral literal);

	T visit(StringLiteral literal);
}
