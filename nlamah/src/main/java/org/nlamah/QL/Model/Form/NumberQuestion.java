package org.nlamah.QL.Model.Form;

import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public class NumberQuestion extends InputQuestion 
{
	private NumberLiteral insertedNumber;
	
	public NumberQuestion(IdentifierLiteral identifier, TextLiteral questionText)
	{
		super(identifier, questionText, QuestionReturnType.NUMBER);
		
		insertedNumber = new NumberLiteral("0");
	}

	public NumberLiteral insertedNumber()
	{
		return this.insertedNumber;
	}
	
	public void setInsertedNumber(NumberLiteral insertedNumber)
	{
		this.insertedNumber = insertedNumber;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof NumberQuestion))
		 {
			 return false;
		 }
		 
		 NumberQuestion value = (NumberQuestion)object;
		 
		 if (this.insertedNumber != value.insertedNumber)
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);	
	}
}
