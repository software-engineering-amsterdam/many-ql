package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class QLStylesheet extends QLSNode 
{
	private IdentifierValue identifier;
	private List<Page> pages;
	
	public QLStylesheet(IdentifierValue identifier, List<Page> pages)
	{
		super();
		
		this.identifier = identifier;
		this.pages = pages;
	}
	
	public IdentifierValue identifier()
	{
		return identifier;
	}

	public List<Page> pages() 
	{
		return pages;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
