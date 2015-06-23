package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public abstract class Variable extends Expression {
	public abstract String toString();
	public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
