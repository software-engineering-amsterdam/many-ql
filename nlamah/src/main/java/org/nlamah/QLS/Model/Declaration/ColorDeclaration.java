package org.nlamah.QLS.Model.Declaration;

import java.awt.Color;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class ColorDeclaration extends StyleDeclaration 
{
	private Color color;

	public ColorDeclaration(Color color) 
	{
		super();

		this.color = color;
	}

	public Color primitiveValue()
	{
		return color;
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

		ColorDeclaration value = (ColorDeclaration) object;

		if (!value.color.equals(color))
		{
			return false;
		}

		return true;
	}
}
