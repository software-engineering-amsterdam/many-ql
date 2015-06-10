package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public class IdentifierLiteral extends ValueExpression 
{
	private FormQuestion correspondingQuestion;

	private String identifierValueString;

	public IdentifierLiteral(String identifierValueString)
	{	
		super(null);

		this.identifierValueString = identifierValueString;
	}

	public FormQuestion correspondingQuestion()
	{
		return correspondingQuestion;
	}

	public void setCorrespondingQuestion(FormQuestion question)
	{
		this.correspondingQuestion = question;
	}

	@Override
	public String toString()
	{
		return identifierValueString;
	}

	public QBaseQuestionType type()
	{
		if (correspondingQuestion == null)
		{
			return null;
		}

		return correspondingQuestion.returnType();
	}

	@Override
	public int hashCode() 
	{
		return identifierValueString.hashCode();
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (this == object)
		{
			return true;
		}

		if (!(object instanceof IdentifierLiteral))
		{
			return false;
		}

		IdentifierLiteral value = (IdentifierLiteral) object;

		if (!value.identifierValueString.equals(identifierValueString))
		{
			return false;
		}

		return true;
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}