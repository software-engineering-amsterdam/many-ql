package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class SectionsCollector implements QLSNodeVisitor 
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
			sections.add(section);
			
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Section sectionDeclaration) 
	{
		for (Section section :sectionDeclaration.sections())
		{
			sections.add(section);
			
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(WidgetDeclaration widgetDeclaration) 
	{
		assert(false);;
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion questionDeclaration) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(DefaultDeclaration defaultDeclaration) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(CheckBoxWidgetType checkBoxWidgetType) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(RadioButtonWidgetType radioButtonWidgetType) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(SpinBoxWidgetType spinBoxWidgetType) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(TextValue textValue) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(ColorValue hexNumberValue) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(IdentifierValue identifierValue) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(NumberValue numberValue) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(FontValue fontValue) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(ColorDeclaration colorDeclaration) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(FontDeclaration fontDeclaration) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(WidthDeclaration widthDeclaration) 
	{
		assert(false);
		return null;
	}
}
