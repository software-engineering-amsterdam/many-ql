package ast.expression;

import ast.expression.arithmetic.*;
import ast.expression.comparison.*;
import ast.expression.logical.*;
import ast.expression.variables.*;
import ast.unary.*;


public interface IExpressionVisitor<T> {
	
	public T visit(Brackets expr);
	
	public T visit(Multiplication expr);
	public T visit(Division expr);
	public T visit(Addition expr);
	public T visit(Substraction expr);
	
	public T visit(Equal expr);
	public T visit(NotEqual expr);
	public T visit(LessThan expr);
	public T visit(GreaterThan expr);
	public T visit(LessEqual expr);
	public T visit(GreaterEqual expr);

	public T visit(Not expr);
	public T visit(Plus expr);
	public T visit(Minus expr);
	
	public T visit(And expr);
	public T visit(Or expr);
	
	public T visit(StringVariable string);
	public T visit(IntegerVariable integer);
	public T visit(BooleanVariable bool);
	public T visit(Id identifier);
}
