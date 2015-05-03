package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

public abstract class InputQuestion extends FormQuestion 
{
	public InputQuestion(IdentifierLiteral identifier, TextLiteral questionText, QBaseQuestionType type) 
	{
		super(identifier, questionText, type);
	}

	@Override 
	public boolean equals(Object object) 
	{
		switch (equalityStateStack.peek())
		{
		case IDENTIFIER:
		{
			if (!super.equals(object))
			{
				return false;
			}
			
			break;
		}

		case QUESTIONTEXT:
		{
			if (!super.equals(object))
			{
				return false;
			}
			
			break;
		}
		default:
		{
			if (!super.equals(object))
			{
				return false;
			}

			if (!(object instanceof InputQuestion))
			{
				return false;
			}
			
			break;
		}
		}
		
		return true;
	}
	
	@Override
	public void push(QBaseEqualityState state) 
	{
		equalityStateStack.push(state);
		
	}

	@Override
	public QBaseEqualityState popState() 
	{
		return equalityStateStack.pop();
	}
}
