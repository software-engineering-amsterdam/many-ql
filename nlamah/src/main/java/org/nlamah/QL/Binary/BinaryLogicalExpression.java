package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public abstract class BinaryLogicalExpression extends BinaryExpression 
{
	public BinaryLogicalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
