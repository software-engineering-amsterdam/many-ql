package org.nlamah.QL.Model.Expression.Abstract;


public abstract class BinaryLogicalExpression extends BinaryExpression 
{
	public BinaryLogicalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
