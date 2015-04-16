package org.nlamah.QL.Literal;

import org.nlamah.QL.Expression.ExpressionVisitor;

public class NumberLiteral extends ValueExpression 
{		
	public NumberLiteral(String numberValueString)
	{
		super(numberValueString, "number");
	}
	
	public int value()
	{
		return Integer.parseInt(valueString);
	}
	
	@Override
	public ValueExpression accept(ExpressionVisitor visitor) 
	{
		return this;
	}
}
