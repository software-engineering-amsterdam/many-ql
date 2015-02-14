package ast.expression;

import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;



public interface IExpressionVisitor<T> {
	public T visit(ArithmeticExpression expr);
	
	public T visit(StringVariable string);
	public T visit(IntegerVariable integer);
	public T visit(BooleanVariable bool);
	public T visit(Id identifier);
}
