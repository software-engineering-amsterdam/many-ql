package org.nlamah.QL.Model.Expression.Unary;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Abstract.UnaryComputationalExpression;

public class PlusExpression extends UnaryComputationalExpression 
{
	public PlusExpression(Expression expression) 
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

		if (!(object instanceof PlusExpression))
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
		case NUMBER: return true;
		default: return false;
		}
	}
}