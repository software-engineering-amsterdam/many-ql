package ast.expression;

import ast.expression.arithmetic.*;
import ast.expression.comparison.*;
import ast.expression.variables.*;


public interface IExpressionVisitor<T> {
	public T visit(MultiplicationExpression expr);
	public T visit(DivisionExpression expr);
	public T visit(AdditionExpression expr);
	public T visit(SubstractionExpression expr);
	
	public T visit(EqualExpression expr);
	public T visit(NotEqualExpression expr);
	public T visit(LessThanExpression expr);
	public T visit(GreaterThanExpression expr);
	public T visit(LessEqualExpression expr);
	public T visit(GreaterEqualExpression expr);
	
	public T visit(StringVariable string);
	public T visit(IntegerVariable integer);
	public T visit(BooleanVariable bool);
	public T visit(Id identifier);
}
