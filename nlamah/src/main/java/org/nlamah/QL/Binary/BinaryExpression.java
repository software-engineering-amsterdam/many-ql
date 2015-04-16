package org.nlamah.QL.Binary;

import org.nlamah.QL.Expression.Expression;

public abstract class BinaryExpression extends Expression 
{
	private Expression leftHandExpression;
	private Expression rightHandExpression;
	
	public BinaryExpression(Expression leftHandExpression, Expression rightHandExpression)
	{
		this.leftHandExpression = leftHandExpression;
		this.rightHandExpression = rightHandExpression;
	}
	
	public Expression leftHandExpression()
	{
		return this.leftHandExpression;
	}
	
	public Expression rightHandExpression()
	{
		return this.rightHandExpression;
	}
}
