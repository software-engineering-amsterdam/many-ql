package org.nlamah.QLS.Model.Declaration;

import java.awt.Font;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class FontDeclaration extends StyleDeclaration 
{
	private Font font;

	public FontDeclaration(Font font) 
	{
		super();

		this.font = font;
	}

	public Font primitiveValue()
	{
		return font;
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

		if (!(object instanceof FontDeclaration))
		{
			return false;
		}

		FontDeclaration value = (FontDeclaration) object;

		if (!value.font.equals(font))
		{
			return false;
		}

		return true;
	}
	
	@Override
	public int hashCode()
	{
		return font.toString().hashCode();
	}
}
