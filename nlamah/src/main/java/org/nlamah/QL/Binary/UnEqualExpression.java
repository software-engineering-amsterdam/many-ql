package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class UnEqualExpression extends BinaryLogicalExpression 
{
	public UnEqualExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
