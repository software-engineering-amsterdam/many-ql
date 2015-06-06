package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.Constants.QBaseQuestionType;

public abstract class UnaryLogicalExpression extends UnaryExpression 
{
	public UnaryLogicalExpression(Expression expression) 
	{
		super(expression, QBaseQuestionType.BOOLEAN);
	}
}