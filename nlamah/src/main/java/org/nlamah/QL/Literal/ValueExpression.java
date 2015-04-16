package org.nlamah.QL.Literal;

import org.nlamah.QL.Expression.Expression;

public abstract class ValueExpression extends Expression 
{
	private String valueString;
	
	public ValueExpression(String valueString)
	{
		this.valueString = valueString;
	}
}
