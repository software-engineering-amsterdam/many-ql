package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;


public abstract class InputQuestion extends Question 
{
	public InputQuestion(IdentifierLiteral identifier, TextLiteral questionText, QBaseQuestionType type) 
	{
		super(identifier, questionText, type);
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof InputQuestion))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
