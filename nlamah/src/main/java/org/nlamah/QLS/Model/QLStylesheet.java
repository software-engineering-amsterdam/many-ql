package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class QLStylesheet extends QLStylesheetBlock 
{
	public QLStylesheet(IdentifierValue identifier, List<Page> pages, List<DefaultDeclaration> defaultDeclarations)
	{
		super(identifier, pages, defaultDeclarations);
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
