package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class SmallerThanExpression extends BinaryLogicalExpression 
{
	public SmallerThanExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
