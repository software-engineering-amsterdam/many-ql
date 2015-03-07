package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public abstract class Variable extends Expression {
	/*
	private final T value;
	
	public Variable(T value) {
		this.value = value;
	}
	
	public T getVariable() {
		return value;
	}
	
	public String toString() {
		return value.toString();
	}
	*/
	public abstract String toString();
	 public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
