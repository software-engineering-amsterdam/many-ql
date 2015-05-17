package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

public class TextLiteral extends ValueExpression 
{
	String textValueString;

	public TextLiteral(String textValueString)
	{
		super(QBaseQuestionType.TEXT);

		this.textValueString = textValueString;
	}

	public String value()
	{
		return textValueString;
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

		if (!(object instanceof TextLiteral))
		{
			return false;
		}

		TextLiteral value = (TextLiteral) object;

		if (!value.textValueString.equals(textValueString))
		{
			return false;
		}

		return true;
	}

	@Override
	public int hashCode()
	{
		return textValueString.hashCode();
	}

	@Override
	public String toString()
	{
		return textValueString;
	}
}
