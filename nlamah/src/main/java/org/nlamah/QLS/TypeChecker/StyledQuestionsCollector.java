package org.nlamah.QLS.TypeChecker;

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

public class StyledQuestionsCollector implements QLSNodeVisitor
{
	private List<StyledQuestion> questions;
	
	public StyledQuestionsCollector(QLStylesheet stylesheet)
	{
		super();
		
		questions = new ArrayList<StyledQuestion>();
		
		stylesheet.accept(this);
	}
	
	public List<StyledQuestion> questions()
	{
		return questions;
	}
	
	@Override
	public QLSNode visit(QLStylesheet stylesheet) 
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
	public QLSNode visit(Section sectionDeclaration) 
	{
		for (StyledQuestion questionDeclaration : sectionDeclaration.questionDeclarations())
		{
			questions.add(questionDeclaration);
		}
		
		for (Section section : sectionDeclaration.sections())
		{
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(WidgetDeclaration widgetDeclaration) 
	{
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion questionDeclaration) 
	{
		return null;
	}

	@Override
	public QLSNode visit(DefaultDeclaration defaultDeclaration) 
	{	
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
