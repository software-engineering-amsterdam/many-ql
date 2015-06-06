package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.Constants.QBaseQuestionType;

public abstract class UnaryComputationalExpression extends UnaryExpression
{
	public UnaryComputationalExpression(Expression expression) 
	{
		super(expression, QBaseQuestionType.NUMBER);
	}
}