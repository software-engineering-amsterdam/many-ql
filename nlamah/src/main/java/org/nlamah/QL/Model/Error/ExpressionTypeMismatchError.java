package org.nlamah.QL.Model.Error;

import org.nlamah.QL.Model.Error.Abstract.QLError;
import org.nlamah.QL.Model.Expression.Abstract.Expression;

public class ExpressionTypeMismatchError extends QLError 
{
	private Expression expression;

	public ExpressionTypeMismatchError(Expression expression)
	{
		super();

		this.expression = expression;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + expression.startsOnLine + ":"  + expression.startsAtCharacterPosition;

		errorString += " There is a type mismatch in the expression: " + expression.nodeString;

		return errorString;	
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof ExpressionTypeMismatchError))
		{
			return false;
		}

		ExpressionTypeMismatchError value = (ExpressionTypeMismatchError)object;

		if (!this.expression.equals(value.expression))
		{
			return false;
		}

		return true;
	}
}
