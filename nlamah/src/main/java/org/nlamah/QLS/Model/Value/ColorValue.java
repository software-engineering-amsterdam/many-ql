package org.nlamah.QLS.Model.Value;

import java.awt.Color;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

public class ColorValue extends DeclarationValue 
{
	private Color color;
	
	public ColorValue(Color color) 
	{
		super();
		
		this.color = color;
	}

	public Color color()
	{
		return color;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return color.toString();
	}	
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof ColorValue))
		 {
			 return false;
		 }
		 
		 ColorValue value = (ColorValue) object;

		 if (!(this.color.equals(value.color)))
		 {
			 return false;
		 }

		 return true;
	 }
}
