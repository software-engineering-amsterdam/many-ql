package org.nlamah.QL.Model.Form;

import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class InputQuestion extends FormQuestion 
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

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
