package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class FontSizeDeclaration extends StyleDeclaration 
{
	public FontSizeDeclaration(DeclarationValue value) 
	{
		super(value);
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
