package org.uva.qls.visitor;

import org.uva.qls.ast.literal.BoolLiteral;
import org.uva.qls.ast.literal.ColorLiteral;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.StrLiteral;

public interface LiteralVisitor<T> {

	public T visit(BoolLiteral boolLiteral);

	public T visit(IntLiteral intLiteral);

	public T visit(StrLiteral strLiteral);

	public T visit(ColorLiteral colorLiteral);

}
