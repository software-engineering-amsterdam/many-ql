package org.nlamah.QL.Model.Form;

import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public class TextQuestion extends InputQuestion 
{
	private TextLiteral insertedText;
	
	public TextQuestion(IdentifierLiteral identifier, TextLiteral questionText) 
	{
		super(identifier, questionText, LiteralType.TEXT);
		
		insertedText = new TextLiteral("");
	}

	public TextLiteral insertedText()
	{
		return insertedText;
	}
	
	public void setInsertedText(TextLiteral insertedText)
	{
		this.insertedText = insertedText;
	}

	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof TextQuestion))
		 {
			 return false;
		 }
		 
		 TextQuestion value = (TextQuestion)object;
		 
		 if (this.insertedText != value.insertedText)
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
