package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QLS.Model.Abstract.AbstractQLSVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

public class SectionsCollector extends AbstractQLSVisitor 
{	
	List<Section> sections;
	
	public SectionsCollector() 
	{
		super();
	}
	
	public List<Section> sectionsForPage(Page page)
	{
		sections = new ArrayList<Section>();
		
		page.accept(this);
		
		return sections;
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{
		for (Page page : stylesheet.pages())
		{
			page.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Page page) 
	{
		for (Section section : page.sections())
		{			
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{
		sections.add(section);
		
		for (SectionItem sectionItem :section.sectionItems())
		{
			sectionItem.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion styledQuestion) 
	{
		return null;
	}
}
