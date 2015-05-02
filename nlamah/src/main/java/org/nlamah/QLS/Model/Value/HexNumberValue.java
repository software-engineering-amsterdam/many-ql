package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.QLStylesheetBlock;

public class HexNumberValue extends DeclarationValue 
{
	private String hexNumber;
	
	public HexNumberValue(String hexNumber)
	{
		super();
		
		this.hexNumber = hexNumber;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return hexNumber;
	}	
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof HexNumberValue))
		 {
			 return false;
		 }
		 
		 HexNumberValue value = (HexNumberValue) object;

		 
		 if (!(this.hexNumber.equals(value.hexNumber)))
		 {
			 return false;
		 }

		 return true;
	 }
}
