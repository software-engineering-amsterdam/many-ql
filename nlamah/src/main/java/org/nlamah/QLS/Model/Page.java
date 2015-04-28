package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

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
	public QLNode accept(QLNodeVisitor visitor) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
