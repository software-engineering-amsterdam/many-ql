package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class Page extends QLSNode 
{
	private IdentifierValue identifier;
	private List<Section> sections;
	
	public Page(IdentifierValue identifier, List<Section> sections) 
	{
		super();
		
		this.identifier = identifier;
		this.sections = sections;
	}
	
	public IdentifierValue identifier()
	{
		return identifier;
	}
	
	public List<Section> sectionItems()
	{
		return sections;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
