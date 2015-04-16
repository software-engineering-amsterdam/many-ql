package org.nlamah.QL.Unary;

import org.nlamah.QL.Expression.Expression;

public abstract class UnaryExpression extends Expression 
{
	private Expression expression;
	
	public UnaryExpression (Expression expression)
	{
		this.expression = expression;
	}
	
	public Expression expression()
	{
		return this.expression;
	}
}
