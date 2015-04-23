package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public abstract class UnaryLogicalExpression extends UnaryExpression 
{
	public UnaryLogicalExpression(Expression expression) 
	{
		super(expression, LiteralType.BOOLEAN);
	}
}
