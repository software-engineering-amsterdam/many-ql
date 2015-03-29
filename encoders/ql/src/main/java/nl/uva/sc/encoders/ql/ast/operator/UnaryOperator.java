package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.visitor.UnaryOperatorVisitor;

public interface UnaryOperator {

	<T> T accept(UnaryOperatorVisitor<T> visitor);

	boolean supports(DataType dataType);
}
