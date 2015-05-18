package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class UnaryComputationalExpression extends UnaryExpression
{
	public UnaryComputationalExpression(Expression expression) 
	{
		super(expression, QBaseQuestionType.NUMBER);
	}
}