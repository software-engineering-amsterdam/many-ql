package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
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
	private QLStylesheet stylesheet;
	private List<WidgetDeclaration> widgetDeclarations;
	
	public WidgetDeclarationsCollector(QLStylesheet stylesheet) 
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
	public QLSNode visit(QLStylesheet stylesheet) 
	{
		for (Page page : stylesheet.pages())
		{
			page.accept(this);
		}
		
		for (DefaultDeclaration defaultDeclaration : stylesheet.defaultDeclarations())
		{
			defaultDeclaration.accept(this);
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
		
		for (DefaultDeclaration defaultDeclaration : page.defaultDeclarations())
		{
			defaultDeclaration.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Section sectionDeclaration) 
	{
		for (StyledQuestion questionDeclaration : sectionDeclaration.questionDeclarations())
		{
			questionDeclaration.accept(this);
		}
		
		for (Section section : sectionDeclaration.sections())
		{
			section.accept(this);
		}
		
		for (DefaultDeclaration defaultDeclaration : sectionDeclaration.defaultDeclarations())
		{
			defaultDeclaration.accept(this);
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
	public QLSNode visit(StyledQuestion questionDeclaration) 
	{
		if (questionDeclaration.widgetDeclaration() != null)
		{
			questionDeclaration.widgetDeclaration().accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(DefaultDeclaration defaultDeclaration) 
	{	
		for (StyleDeclaration styleDeclaration : defaultDeclaration.styleDeclarations())
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
