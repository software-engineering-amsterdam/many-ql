package ast.expression;


public interface IExpressionVisitor<T> {
	 T visit(ArithmeticExpression expr);
}
