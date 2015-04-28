package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

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
	public QLNode accept(QLNodeVisitor visitor) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
