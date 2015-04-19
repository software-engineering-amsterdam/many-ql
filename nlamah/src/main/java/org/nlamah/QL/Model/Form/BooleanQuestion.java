package org.nlamah.QL.Model.Form;

import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public class BooleanQuestion extends InputQuestion 
{
	private BooleanLiteral checked;
	
	public BooleanQuestion(IdentifierLiteral identifier, TextLiteral questionText) 
	{
		super(identifier, questionText, QuestionReturnType.BOOLEAN);
		
		checked = new BooleanLiteral("no");
	}
	
	public BooleanLiteral checked() 
	{
		return checked;
	}
	
	public void setChecked(BooleanLiteral checked)
	{
		this.checked = checked;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof BooleanQuestion))
		 {
			 return false;
		 }
		 
		 BooleanQuestion value = (BooleanQuestion)object;
		 
		 if (this.checked != value.checked)
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
