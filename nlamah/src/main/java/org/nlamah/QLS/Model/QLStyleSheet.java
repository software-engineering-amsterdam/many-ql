package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

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
	public QLNode accept(QLNodeVisitor visitor) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
