package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class ValueExpression extends Expression 
{
	protected String valueString;
	
	public ValueExpression(String valueString, QBaseQuestionType type)
	{
		super(type);
		
		this.valueString = valueString;
	}
	
	 @Override 
	 public boolean equals(Object object) 
	 {	 
		 if (!(object instanceof ValueExpression))
		 {
			 return false;
		 }
		 
		 ValueExpression value = (ValueExpression) object;
		 
		 if (!value.valueString.equals(valueString))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	 
	@Override
	public String toString()
	{
		return valueString;
	}
}
