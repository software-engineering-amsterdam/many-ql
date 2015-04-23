package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public abstract class ValueExpression extends Expression 
{
	protected String valueString;
	
	public ValueExpression(String valueString, LiteralType type)
	{
		super(type);
		
		this.valueString = valueString;
	}
	
	 @Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof ValueExpression))
		 {
			 return false;
		 }
		 
		 ValueExpression value = (ValueExpression) object;
		 
		 return value.valueString.equals(valueString);
	 }
	 
	@Override
	public String toString()
	{
		return valueString;
	}
}
