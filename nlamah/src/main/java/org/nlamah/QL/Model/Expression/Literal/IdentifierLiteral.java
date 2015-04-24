package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class IdentifierLiteral extends ValueExpression 
{
	private Question correspondingQuestion;
	
	public IdentifierLiteral(String identifierValueString)
	{	
		super(identifierValueString, null);
	}
	
	public Question correspondingQuestion()
	{
		return correspondingQuestion;
	}
	
	public void setCorrespondingQuestion(Question question)
	{
		this.correspondingQuestion = question;
	}
	
	@Override
	public LiteralType type()
	{
		if (correspondingQuestion == null)
		{
			return null;
		}
		
		return correspondingQuestion.returnType();
	}
	
	public ValueExpression representedValue()
	{
		if (correspondingQuestion instanceof ComputedQuestion)
		{
			ComputedQuestion question = (ComputedQuestion) correspondingQuestion;
			
			return question.computedValue();
		}
		
		switch (correspondingQuestion.returnType())
		{
			case BOOLEAN: return ((BooleanQuestion) correspondingQuestion).checked();
			case NUMBER: return ((NumberQuestion) correspondingQuestion).insertedNumber();
			case TEXT: return ((TextQuestion) correspondingQuestion).insertedText();
			default: return null;
		}
	}
	
	@Override
    public int hashCode() 
	{
        final int prime = 31;
        int result = 1;
        result = prime * result + ((valueString == null) ? 0 : valueString.hashCode());
        return result;
    }
	
	@Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof IdentifierLiteral))
		 {
			 return false;
		 }
		 
		 IdentifierLiteral value = (IdentifierLiteral) object;
		 
		 return value.valueString.equals(valueString);
	 }
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
