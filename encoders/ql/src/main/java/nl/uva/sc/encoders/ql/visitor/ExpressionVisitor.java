package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.StringLiteral;

public interface ExpressionVisitor<T> {

	T visit(UnaryExpression unaryExpression);

	T visit(BinaryExpression binaryExpression);

	T visit(BracedExpression bracedExpression);

	T visit(NameExpression nameExpression);

	T visit(StringLiteral stringLiteral);

	T visit(IntegerLiteral integerLiteral);

	T visit(BooleanLiteral booleanLiteral);
}
