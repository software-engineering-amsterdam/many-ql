package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

public abstract class Question extends FormElement 
{
	private TextLiteral questionText;
	private QBaseQuestionType type;
	
	public Question(IdentifierLiteral identifier, TextLiteral questionString, QBaseQuestionType type) 
	{
		super(identifier);
		
		this.questionText = questionString;
		this.type = type;
		
		if (identifier != null)
		{
			identifier.setParentNode(this);
		}
		
		if (questionString != null)
		{
			questionString.setParentNode(this);
		}
	}
	
	public QBaseQuestionType returnType()
	{
		return type;
	}
	
	public TextLiteral questionText()
	{
		return questionText;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof Question))
		 {
			 return false;
		 }
		 
		 Question value = (Question) object;
		 
		 if (!(this.questionText.equals(value.questionText)))
		 {
			 return false;
		 }
		 
		 if (!(this.type.equals(value.type)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
