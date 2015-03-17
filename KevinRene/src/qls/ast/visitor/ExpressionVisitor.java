package qls.ast.visitor;

import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;

public interface ExpressionVisitor<T> extends ql.ast.visitor.ExpressionVisitor<T> {
	public T visit(BooleanLiteral booleanLiteral);
	public T visit(FloatLiteral floatLiteral);
	public T visit(IntegerLiteral integerLiteral);
	public T visit(StringLiteral stringLiteral);
}
