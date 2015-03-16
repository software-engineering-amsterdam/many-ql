package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.visitor.UnaryOperatorVisitor;

public interface UnaryOperator {

	<T> T accept(UnaryOperatorVisitor<T> visitor);
}
