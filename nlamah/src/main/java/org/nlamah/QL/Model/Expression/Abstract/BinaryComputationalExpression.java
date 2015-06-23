package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.Constants.QBaseQuestionType;

public abstract class BinaryComputationalExpression extends BinaryExpression
{
	public BinaryComputationalExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression, QBaseQuestionType.NUMBER);
	}
}