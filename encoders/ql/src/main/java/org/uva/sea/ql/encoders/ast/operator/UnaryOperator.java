package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.visitor.UnaryOperatorVisitor;

public interface UnaryOperator {

	<T> T accept(UnaryOperatorVisitor<T> visitor);
}
