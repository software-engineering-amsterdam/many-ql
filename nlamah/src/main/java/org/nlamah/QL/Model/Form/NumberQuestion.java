package org.nlamah.QL.Model.Form;

import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.InputQuestion;

public class NumberQuestion extends InputQuestion 
{
	private NumberLiteral insertedNumber;

	public NumberQuestion(IdentifierLiteral identifier, TextLiteral questionText)
	{
		super(identifier, questionText, QBaseQuestionType.NUMBER);

		insertedNumber = new NumberLiteral("0");
	}

	public NumberLiteral insertedNumber()
	{
		return this.insertedNumber;
	}

	public void setInsertedNumber(NumberLiteral insertedNumber)
	{
		this.insertedNumber = insertedNumber;
	}

	@Override 
	public boolean equals(Object object) 
	{
		switch (equalityStateStack.peek())
		{
		case IDENTIFIER_ONLY:
		{
			if (!super.equals(object))
			{
				return false;
			}
			
			break;
		}

		case QUESTIONTEXT_ONLY:
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

			if (!(object instanceof NumberQuestion))
			{
				return false;
			}

			NumberQuestion value = (NumberQuestion)object;

			if (!this.insertedNumber.equals(value.insertedNumber))
			{
				return false;
			}
			
			break;
		}
		}
		
		return true;
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);	
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
