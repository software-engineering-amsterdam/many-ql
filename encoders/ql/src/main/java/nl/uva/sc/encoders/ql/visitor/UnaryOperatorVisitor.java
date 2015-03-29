package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.operator.NotOperator;

public interface UnaryOperatorVisitor<T> {

	T visit(NotOperator operator);
}
