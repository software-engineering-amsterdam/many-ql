package nl.uva.sc.encoders.ql.ast.literal;

import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.visitor.LiteralVisitor;

public interface Literal {

	DataType getType();

	<T> T accept(LiteralVisitor<T> visitor);
}
