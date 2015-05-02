package org.nlamah.QLS.Model.Declaration;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Value.ColorValue;

public class ColorDeclaration extends StyleDeclaration 
{
	public ColorDeclaration(ColorValue value) 
	{
		super(value);
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof ColorDeclaration))
		{
			return false;
		}

		return true;
	}
}
