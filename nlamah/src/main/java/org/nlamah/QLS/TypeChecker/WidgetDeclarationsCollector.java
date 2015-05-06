package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class WidgetDeclarationsCollector implements QLSNodeVisitor
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
		if (styledQuestion.widgetDeclaration() != null)
		{
			styledQuestion.widgetDeclaration().accept(this);
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
	public QLSNode visit(CheckBoxWidgetType checkBoxWidgetType) 
	{
		return null;
	}

	@Override
	public QLSNode visit(RadioButtonWidgetType radioButtonWidgetType) 
	{
		return null;
	}

	@Override
	public QLSNode visit(SpinBoxWidgetType spinBoxWidgetType) 
	{
		return null;
	}

	@Override
	public QLSNode visit(TextValue textValue) 
	{
		return null;
	}

	@Override
	public QLSNode visit(ColorValue hexNumberValue) 
	{
		return null;
	}

	@Override
	public QLSNode visit(IdentifierValue identifierValue) 
	{
		return null;
	}

	@Override
	public QLSNode visit(NumberValue numberValue) 
	{
		return null;
	}

	@Override
	public QLSNode visit(FontValue fontValue) 
	{
		return null;
	}
	
	@Override
	public QLSNode visit(ColorDeclaration colorDeclaration) 
	{
		return null;
	}

	@Override
	public QLSNode visit(FontDeclaration fontDeclaration) 
	{
		return null;
	}

	@Override
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration) 
	{
		return null;
	}

	@Override
	public QLSNode visit(WidthDeclaration widthDeclaration) 
	{
		return null;
	}
}
