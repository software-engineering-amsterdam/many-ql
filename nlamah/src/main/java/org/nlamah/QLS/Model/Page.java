package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class Page extends QLSNode 
{
	private String identifier;
	private ArrayList<SectionElement> sectionItems;
	
	public Page(String identifier, ArrayList<SectionElement> sectionItems) 
	{
		super();
		
		this.identifier = identifier;
		this.sectionItems = sectionItems;
	}
	
	public String identifier()
	{
		return identifier;
	}
	
	public ArrayList<SectionElement> sectionItems()
	{
		return sectionItems;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
