package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public class EqualExpression extends BinaryLogicalExpression 
{
	public EqualExpression(Expression leftHandExpression, Expression rightHandExpression) 
	 {
		super(leftHandExpression, rightHandExpression);
	}
}
