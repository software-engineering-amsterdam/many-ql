package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class GreaterThanExpression extends BinaryLogicalExpression 
{
	public GreaterThanExpression(Expression leftHandExpression, Expression rightHandExpression)
	{
		super(leftHandExpression, rightHandExpression);
	}
}
