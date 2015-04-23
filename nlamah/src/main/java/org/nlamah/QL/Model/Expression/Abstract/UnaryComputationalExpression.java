package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;


public abstract class UnaryComputationalExpression extends UnaryExpression
{
	public UnaryComputationalExpression(Expression expression) 
	{
		super(expression, LiteralType.NUMBER);
	}
}
