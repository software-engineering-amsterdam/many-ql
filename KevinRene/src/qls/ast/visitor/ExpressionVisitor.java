package qls.ast.visitor;

import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;

public interface ExpressionVisitor<T> extends ql.ast.visitor.ExpressionVisitor<T> {
	public T visit(BooleanLiteral stringLiteral);
	public T visit(FloatLiteral stringLiteral);
	public T visit(IntegerLiteral stringLiteral);
	public T visit(StringLiteral stringLiteral);
}
