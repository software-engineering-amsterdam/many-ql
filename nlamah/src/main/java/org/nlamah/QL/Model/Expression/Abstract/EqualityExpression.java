package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public abstract class EqualityExpression extends BinaryExpression 
{
	public EqualityExpression(Expression leftHandExpression, Expression rightHandExpression, LiteralType type) 
	{
		super(leftHandExpression, rightHandExpression, LiteralType.BOOLEAN);
	}
}
