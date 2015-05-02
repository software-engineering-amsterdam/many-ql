package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.QuestionDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.TypeValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class GatherValues implements QLSNodeVisitor
{

	private List<DeclarationValue> values;
	
	public GatherValues()
	{
		super();
		
		values = new ArrayList<DeclarationValue>();
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
		for (QuestionDeclaration questionDeclaration : sectionDeclaration.questionDeclarations())
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
		return null;
	}

	@Override
	public QLSNode visit(QuestionDeclaration questionDeclaration) 
	{
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
	public QLSNode visit(TypeValue typeValue) 
	{
		values.add(typeValue);
		
		return null;
	}

	@Override
	public QLSNode visit(ColorValue hexNumberValue) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLSNode visit(IdentifierValue identifierValue) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLSNode visit(NumberValue numberValue) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLSNode visit(FontValue fontValue) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public QLSNode visit(ColorDeclaration colorDeclaration) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLSNode visit(FontDeclaration fontDeclaration) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLSNode visit(FontSizeDeclaration fontSizeDeclaration) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLSNode visit(WidthDeclaration widthDeclaration) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
