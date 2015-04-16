package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class OrExpression extends BinaryLogicalExpression
{
	public OrExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
