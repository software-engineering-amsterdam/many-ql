package qls.ast.visitor;

import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;

public interface ExpressionVisitor<T> extends ql.ast.visitor.ExpressionVisitor<T> {
	default T visit(BooleanLiteral booleanLiteral) {
		return null;
	}

	default T visit(FloatLiteral floatLiteral) {
		return null;
	}

	default T visit(IntegerLiteral integerLiteral) {
		return null;
	}

	default T visit(StringLiteral stringLiteral) {
		return null;
	}
}
