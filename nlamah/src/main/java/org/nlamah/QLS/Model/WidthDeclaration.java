package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class WidthDeclaration extends StyleDeclaration 
{

	public WidthDeclaration(NumberValue numberValue) 
	{
		super(numberValue);
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
