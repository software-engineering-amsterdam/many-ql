package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.visitor.BinaryOperatorVisitor;

public interface BinaryOperator {

	<T> T accept(BinaryOperatorVisitor<T> visitor);
}
