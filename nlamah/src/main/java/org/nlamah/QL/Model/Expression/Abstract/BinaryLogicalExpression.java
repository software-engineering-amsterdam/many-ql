package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class BinaryLogicalExpression extends BinaryExpression 
{
	public BinaryLogicalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression, QBaseQuestionType.BOOLEAN);
	}
}
