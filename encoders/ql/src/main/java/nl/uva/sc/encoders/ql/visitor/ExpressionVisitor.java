package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;

public interface ExpressionVisitor<T> {

	T visit(UnaryExpression unaryExpression);

	T visit(BinaryExpression binaryExpression);

	T visit(BracedExpression bracedExpression);

	T visit(NameExpression nameExpression);

	T visit(LiteralExpression literalExpression);
}
