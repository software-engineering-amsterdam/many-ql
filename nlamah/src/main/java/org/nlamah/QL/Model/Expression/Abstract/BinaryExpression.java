package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class BinaryExpression extends ComposedExpression 
{
	private Expression leftHandExpression;
	private Expression rightHandExpression;

	public BinaryExpression(Expression leftHandExpression, Expression rightHandExpression, QBaseQuestionType type)
	{
		super(type);

		this.leftHandExpression = leftHandExpression;
		this.rightHandExpression = rightHandExpression;

		leftHandExpression.setParentNode(this);
		rightHandExpression.setParentNode(this);
	}

	public Expression leftHandExpression()
	{
		return this.leftHandExpression;
	}

	public Expression rightHandExpression()
	{
		return this.rightHandExpression;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof BinaryExpression))
		{
			return false;
		}

		BinaryExpression value = (BinaryExpression)object;

		if (!(this.leftHandExpression.equals(value.leftHandExpression)))
		{
			return false;
		}

		if (!(this.rightHandExpression.equals(value.rightHandExpression)))
		{
			return false;
		}

		return true;
	}
}