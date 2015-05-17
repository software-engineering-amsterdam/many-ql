package org.nlamah.QLS.Model.Declaration;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class WidthDeclaration extends StyleDeclaration 
{	
	private int width;

	public WidthDeclaration(int width) 
	{
		super();

		this.width = width;
	}

	public int primitiveValue()
	{
		return width;
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

		if (!(object instanceof WidthDeclaration))
		{
			return false;
		}

		WidthDeclaration value = (WidthDeclaration) object;

		if (value.width != width)
		{
			return false;
		}

		return true;
	}
}
