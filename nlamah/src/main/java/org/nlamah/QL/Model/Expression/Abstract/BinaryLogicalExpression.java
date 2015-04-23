package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public abstract class BinaryLogicalExpression extends BinaryExpression 
{
	public BinaryLogicalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression, LiteralType.BOOLEAN);
	}
}
