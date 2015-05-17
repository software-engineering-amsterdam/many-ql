package org.nlamah.QL.Model.Expression.Unary;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Abstract.UnaryLogicalExpression;

public class NotExpression extends UnaryLogicalExpression 
{
	public NotExpression(Expression expression) 
	{
		super(expression);
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof NotExpression))
		{
			return false;
		}

		return true;
	}

	@Override
	public boolean isSafeForType(QBaseQuestionType type) 
	{
		switch(type)
		{
		case BOOLEAN: return true;
		default: return false;
		}
	}
}
