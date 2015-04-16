package org.nlamah.QL.Literal;

import org.nlamah.QL.Expression.ExpressionVisitor;

public class IdentifierLiteral extends ValueExpression 
{
	public IdentifierLiteral(String identifierValueString)
	{	
		super(identifierValueString, "identifier");
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
