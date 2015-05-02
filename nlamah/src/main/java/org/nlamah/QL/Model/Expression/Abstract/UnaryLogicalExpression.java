package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class UnaryLogicalExpression extends UnaryExpression 
{
	public UnaryLogicalExpression(Expression expression) 
	{
		super(expression, QBaseQuestionType.BOOLEAN);
	}
}
