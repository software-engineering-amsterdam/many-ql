package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class GreaterThanEqualExpression extends BinaryLogicalExpression 
{
	public GreaterThanEqualExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
