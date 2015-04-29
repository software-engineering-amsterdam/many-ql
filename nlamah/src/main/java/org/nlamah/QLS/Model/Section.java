package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class Section extends SectionElement 
{
	private TextValue titleValue;
	private List<SectionElement> sectionElements;

	public Section(TextValue titleValue, List<SectionElement> sectionElements)
	{
		super();
		
		this.titleValue = titleValue;
		this.sectionElements = sectionElements;
	}
		
	public TextValue description() 
	{
		return titleValue;
	}

	public List<SectionElement> sectionItems() 
	{
		return sectionElements;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
