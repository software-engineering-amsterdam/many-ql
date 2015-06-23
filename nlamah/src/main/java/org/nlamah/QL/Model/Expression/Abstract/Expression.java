package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public abstract class Expression extends QLNode
{		
	private QBaseQuestionType type;

	public Expression(QBaseQuestionType type)
	{
		this.type = type;
	}

	public QBaseQuestionType type()
	{
		return type;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (this == object)
		{
			return true;
		}

		if (!(object instanceof Expression))
		{
			return false;
		}

		Expression value = (Expression) object;

		if (value.type != type)
		{
			return false;
		}

		return true;
	}
	
	@Override
	public int hashCode()
	{
		return type.toString().hashCode();
	}
}