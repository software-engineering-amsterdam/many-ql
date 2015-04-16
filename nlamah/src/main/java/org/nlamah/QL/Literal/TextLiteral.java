package org.nlamah.QL.Literal;

import org.nlamah.QL.Expression.ExpressionVisitor;

public class TextLiteral extends ValueExpression 
{
	public TextLiteral(String textValueString)
	{
		super(textValueString, "text");
	}
	
	public String value()
	{
		return valueString;
	}
	
	@Override
	public ValueExpression accept(ExpressionVisitor visitor) 
	{
		return this;
	}
}
