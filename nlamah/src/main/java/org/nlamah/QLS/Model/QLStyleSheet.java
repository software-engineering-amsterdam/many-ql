package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class QLStyleSheet extends QLSNode 
{
	private String identifier;
	private ArrayList<Page> pages;
	
	public QLStyleSheet(String identifier, ArrayList<Page>pages)
	{
		super();
		
		this.identifier = identifier;
		this.pages = pages;
	}
	
	public String identifier()
	{
		return identifier;
	}

	public ArrayList<Page> pages() 
	{
		return pages;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
