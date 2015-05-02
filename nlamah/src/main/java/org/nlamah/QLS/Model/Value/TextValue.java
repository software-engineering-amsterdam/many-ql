package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

public class TextValue extends DeclarationValue 
{
	private String text;
	
	public TextValue(String text)
	{
		super();
		
		this.text = text;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return text;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof TextValue))
		 {
			 return false;
		 }
		 
		 TextValue value = (TextValue) object;

		 
		 if (!(this.text.equals(value.text)))
		 {
			 return false;
		 }

		 return true;
	 }
}
