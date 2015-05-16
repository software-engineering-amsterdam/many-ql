package org.nlamah.QL.Model.Form.Abstract;

import java.util.Stack;

import org.nlamah.QBase.EqualityStating;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

public abstract class FormQuestion extends FormElement implements EqualityStating
{
	private TextLiteral questionText;
	private QBaseQuestionType type;
	private ValueExpression value;
	
	protected Stack<QBaseEqualityState> equalityStateStack;

	public FormQuestion(IdentifierLiteral identifier, TextLiteral questionString, QBaseQuestionType type) 
	{
		super(identifier);

		this.questionText = questionString;
		this.type = type;
		
		value = QLHelper.defaultValueForQuestionType(type);
		
		equalityStateStack = new Stack<QBaseEqualityState>();
		equalityStateStack.push(QBaseEqualityState.ALL_PROPERTIES);

		if (identifier != null)
		{
			identifier.setParentNode(this);
		}

		if (questionString != null)
		{
			questionString.setParentNode(this);
		}
	}

	public QBaseQuestionType returnType()
	{
		return type;
	}

	public TextLiteral questionText()
	{
		return questionText;
	}

	public ValueExpression value()
	{
		return value;
	}
	
	public void setValue(ValueExpression value)
	{
		this.value = value;
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

			return true;
		}

		case QUESTIONTEXT_ONLY:
		{
			FormQuestion value = (FormQuestion) object;

			if ((this.questionText.equals(value.questionText)))
			{
				return true;
			}

			return false;
		}
		default:
		{
			if (!super.equals(object))
			{
				return false;
			}

			if (!(object instanceof FormQuestion))
			{
				return false;
			}

			FormQuestion value = (FormQuestion) object;

			if (!(this.questionText.equals(value.questionText)))
			{
				return false;
			}

			if (!(this.type.equals(value.type)))
			{
				return false;
			}

			return true;
		}
		}
	}

	@Override
	public int hashCode()
	{
		switch (equalityStateStack.peek())
		{
		case QUESTIONTEXT_ONLY:
		{
			return questionText.toString().hashCode();
		}
		default:
			break;
		}

		return identifier().toString().hashCode();
	}
}
