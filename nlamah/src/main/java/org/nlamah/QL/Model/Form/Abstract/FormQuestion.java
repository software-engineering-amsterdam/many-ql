package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

public abstract class FormQuestion extends FormElement
{
	private TextLiteral questionText;
	private QBaseQuestionType type;

	public boolean compareOnlyQuestionText;

	public FormQuestion(IdentifierLiteral identifier, TextLiteral questionString, QBaseQuestionType type) 
	{
		super(identifier);

		this.questionText = questionString;
		this.type = type;

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

	@Override 
	public boolean equals(Object object) 
	{
		if (compareOnlyQuestionText)
		{
			FormQuestion value = (FormQuestion) object;
			
			if ((this.questionText.equals(value.questionText)))
			{
				return true;
			}

			return false;
		}
		else
		{
			if (!super.equals(object))
			{
				return false;
			}

			if (!(object instanceof FormQuestion))
			{
				return false;
			}

			return true;
		}
	}

	@Override
	public int hashCode()
	{
		if (compareOnlyQuestionText)
		{
			return questionText.toString().hashCode();
		}

		return identifier().toString().hashCode();
	}
}
