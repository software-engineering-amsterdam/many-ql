package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class AndExpression extends BinaryLogicalExpression 
{
	public AndExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
