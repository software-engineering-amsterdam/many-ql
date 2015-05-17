package org.nlamah.QLS.Model.Declaration;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class FontSizeDeclaration extends StyleDeclaration 
{
	private int fontSize;

	public FontSizeDeclaration(int fontSize) 
	{
		super();

		this.fontSize = fontSize;
	}

	public int primitiveValue()
	{
		return fontSize;
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

		if (!(object instanceof FontSizeDeclaration))
		{
			return false;
		}

		FontSizeDeclaration value = (FontSizeDeclaration) object;

		if (value.fontSize != fontSize)
		{
			return false;
		}

		return true;
	}
}
