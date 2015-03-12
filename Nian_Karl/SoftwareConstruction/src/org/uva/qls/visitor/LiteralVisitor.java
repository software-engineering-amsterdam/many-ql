package org.uva.qls.visitor;

import org.uva.qls.ast.literal.BoolLiteral;
import org.uva.qls.ast.literal.ColorLiteral;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.ast.literal.StrLiteral;

public interface LiteralVisitor<T> {

	public T visit(BoolLiteral node);

	public T visit(IntLiteral node);

	public T visit(StrLiteral node);

	public T visit(ColorLiteral node);

	public T visit(IdentifierLiteral node);

}
