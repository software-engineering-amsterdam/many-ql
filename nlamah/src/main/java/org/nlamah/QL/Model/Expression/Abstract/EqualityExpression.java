package org.nlamah.QL.Model.Expression.Abstract;

public abstract class EqualityExpression extends BinaryLogicalExpression 
{
	public EqualityExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
	}
}
