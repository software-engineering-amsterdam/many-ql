package org.nlamah.QL.Model.Expression.Binary;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.BinaryComputationalExpression;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class AddExpression extends BinaryComputationalExpression 
{
	public AddExpression(Expression leftHandExpression, Expression rightHandExpression)
	{
		super(leftHandExpression, rightHandExpression);
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

		if (!(object instanceof AddExpression))
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