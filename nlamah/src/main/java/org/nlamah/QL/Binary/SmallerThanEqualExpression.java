package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class SmallerThanEqualExpression extends BinaryLogicalExpression 
{
	public SmallerThanEqualExpression(Expression leftHandExpression, Expression rightHandExpression)  
	{
		super(leftHandExpression, rightHandExpression);
	}
}
