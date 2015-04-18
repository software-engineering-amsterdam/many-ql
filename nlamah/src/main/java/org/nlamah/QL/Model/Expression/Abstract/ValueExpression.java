package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public abstract class ValueExpression extends Expression 
{
	protected QuestionReturnType type;
	protected String valueString;
	
	public ValueExpression(String valueString, QuestionReturnType type)
	{
		super();
		
		this.type = type;
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
		 
		 return value.valueString.equals(valueString) && value.type == type;
	 }
}
