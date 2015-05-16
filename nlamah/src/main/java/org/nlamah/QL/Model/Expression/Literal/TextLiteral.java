package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

public class TextLiteral extends ValueExpression 
{
	public TextLiteral(String textValueString)
	{
		super(textValueString, QBaseQuestionType.TEXT);
	}

	public String value()
	{
		return valueString;
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

		return true;
	}

	@Override
	public int hashCode()
	{
		return value().hashCode();
	}
}
