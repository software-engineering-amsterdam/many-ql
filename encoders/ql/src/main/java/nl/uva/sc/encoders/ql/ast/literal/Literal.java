package nl.uva.sc.encoders.ql.ast.literal;

import nl.uva.sc.encoders.ql.ast.AstNode;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.visitor.LiteralVisitor;

public interface Literal extends AstNode {

	DataType getType();

	<T> T accept(LiteralVisitor<T> visitor);
}
