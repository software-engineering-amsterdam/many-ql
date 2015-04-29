package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class SectionDeclaration extends SectionElement 
{
	private String description;
	private ArrayList<SectionElement> sectionItems;

	public SectionDeclaration(String description, ArrayList<SectionElement> sectionItems)
	{
		super();
		
		this.description = description;
		this.sectionItems = sectionItems;
	}
		
	public String description() 
	{
		return description;
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
