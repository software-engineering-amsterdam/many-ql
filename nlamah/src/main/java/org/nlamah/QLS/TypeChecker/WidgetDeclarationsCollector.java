package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Interfaces.QLSVisitorAbstract;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;

public class WidgetDeclarationsCollector extends QLSVisitorAbstract
{
	private Stylesheet stylesheet;
	private List<WidgetDeclaration> widgetDeclarations;
	
	public WidgetDeclarationsCollector(Stylesheet stylesheet) 
	{
		super();
		
		this.stylesheet = stylesheet;
	}
	
	public List<WidgetDeclaration> widgetDeclarations()
	{
		if (!QBaseHelper.arrayExistsAndHasElements(widgetDeclarations))
		{
			widgetDeclarations = new ArrayList<WidgetDeclaration>();
			
			stylesheet.accept(this);
		}
		
		return widgetDeclarations;
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{
		for (Page page : stylesheet.pages())
		{
			page.accept(this);
		}
		
		for (DefaultBlock defaultBlock : stylesheet.defaultBlocks())
		{
			defaultBlock.accept(this);
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
		
		for (DefaultBlock defaultBlock : page.defaultBlocks())
		{
			defaultBlock.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{		
		for (SectionItem sectionItem : section.sectionItems())
		{
			sectionItem.accept(this);
		}
		
		for (DefaultBlock defaultBlock : section.defaultBlocks())
		{
			defaultBlock.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(WidgetDeclaration widgetDeclaration) 
	{
		widgetDeclarations.add(widgetDeclaration);
		
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion styledQuestion) 
	{
		if (styledQuestion.styleBlock() != null)
		{
			styledQuestion.styleBlock().accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(DefaultBlock defaultBlock) 
	{	
		for (StyleDeclaration styleDeclaration : defaultBlock.styleDeclarations())
		{
			styleDeclaration.accept(this);
		}
		
		return null;
	}
	
	@Override
	public QLSNode visit(StyleBlock styleBlock)
	{
		for (StyleDeclaration styleDeclaration : styleBlock.styleDeclarations())
		{
			styleDeclaration.accept(this);
		}
		
		return null;
	}
}
