package ast.expression;

import ast.AST;
import ast.type.Type;


public abstract class Expression extends AST {
	public abstract <T> T accept(IExpressionVisitor<T> visitor);
	public abstract String toString();
	public abstract Type getType();
}
