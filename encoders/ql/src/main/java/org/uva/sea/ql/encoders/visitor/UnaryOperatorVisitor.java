package org.uva.sea.ql.encoders.visitor;

import org.uva.sea.ql.encoders.ast.operator.NotOperator;

public interface UnaryOperatorVisitor<T> {

	T visit(NotOperator operator);
}
