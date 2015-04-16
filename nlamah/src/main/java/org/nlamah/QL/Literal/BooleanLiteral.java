package org.nlamah.QL.Literal;

import org.nlamah.QL.Expression.ExpressionVisitor;

public class BooleanLiteral extends ValueExpression
{	
	public BooleanLiteral(String booleanValueString)
	{
		super(booleanValueString, "boolean");	
	}
	
	public boolean value()
	{
		return Boolean.parseBoolean(valueString);
	}

	@Override
	public ValueExpression accept(ExpressionVisitor visitor) 
	{
		return this;
	}
}
