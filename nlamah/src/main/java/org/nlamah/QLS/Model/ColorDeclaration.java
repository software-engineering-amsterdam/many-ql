package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class ColorDeclaration extends StyleDeclaration 
{

	public ColorDeclaration(HexNumberValue value) 
	{
		super(value);
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
