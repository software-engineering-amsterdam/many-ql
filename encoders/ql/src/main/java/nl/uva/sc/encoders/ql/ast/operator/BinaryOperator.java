package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.visitor.BinaryOperatorVisitor;

public interface BinaryOperator {

	<T> T accept(BinaryOperatorVisitor<T> visitor);
}
