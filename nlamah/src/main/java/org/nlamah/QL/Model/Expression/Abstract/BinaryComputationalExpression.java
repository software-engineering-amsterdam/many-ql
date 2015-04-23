package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;


public abstract class BinaryComputationalExpression extends BinaryExpression
{
	public BinaryComputationalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression, LiteralType.NUMBER);
	}
}
