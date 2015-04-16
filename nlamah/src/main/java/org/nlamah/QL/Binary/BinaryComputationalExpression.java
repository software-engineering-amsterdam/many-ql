package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public abstract class BinaryComputationalExpression extends BinaryExpression
{
	public BinaryComputationalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
