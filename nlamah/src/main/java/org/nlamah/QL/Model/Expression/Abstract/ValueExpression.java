package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.Constants.QBaseQuestionType;

public abstract class ValueExpression extends Expression 
{
	public ValueExpression(QBaseQuestionType type)
	{
		super(type);
	}

	@Override 
	public boolean equals(Object object) 
	{	 
		if (!(object instanceof ValueExpression))
		{
			return false;
		}

		return true;
	}
}