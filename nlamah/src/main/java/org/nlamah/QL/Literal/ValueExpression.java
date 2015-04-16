package org.nlamah.QL.Literal;

import org.nlamah.QL.Expression.Expression;

public abstract class ValueExpression extends Expression 
{
	protected String typeString;
	protected String valueString;
	
	public ValueExpression(String valueString, String typeString)
	{
		//TODO make the type of type enum
		this.typeString = typeString;
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
		 
		 
		 ValueExpression value = (ValueExpression)object;
		 
		 return value.valueString.equals(valueString) && value.typeString.equals(typeString);
	 }
	 
}
