package org.nlamah.QLS.Model.Value;

import java.awt.Font;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

public class FontValue extends DeclarationValue
{
	private Font font;
	
	public FontValue(Font font) 
	{
		super();
		
		this.font = font;
	}
	
	public Font font()
	{
		return font;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
