package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.nlamah.QBase.QBaseAbstractTypeChecker;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Error.DoubleDefaultDeclarationError;
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

public class DoubleDefaultDeclarationChecker extends QBaseAbstractTypeChecker implements QLSNodeVisitor 
{
	public DoubleDefaultDeclarationChecker(Stylesheet stylesheet) 
	{
		super();
		
		stylesheet.accept(this);
	}
	
	private void gatherErrors(List<DefaultDeclaration> defaultDeclarations)
	{		
		Set<DefaultDeclaration> set = QBaseHelper.getSetWithDuplicatedObjects(defaultDeclarations, QBaseEqualityState.TYPE);
		
		if (set.size() > 0)
		{
			for (DefaultDeclaration defaultDeclaration : set)
			{
				List<DefaultDeclaration> defaultDeclarationsWithSameType = defaultDeclarationsWithSameType(defaultDeclarations, defaultDeclaration);
				
				errors.add(new DoubleDefaultDeclarationError(new ArrayList<DefaultDeclaration>(defaultDeclarationsWithSameType)));
			}
		}
	}
	
	private List<DefaultDeclaration> defaultDeclarationsWithSameType(List<DefaultDeclaration> defaultDeclarations, DefaultDeclaration referenceDeclaration)
	{
		List<DefaultDeclaration> returnList = new ArrayList<DefaultDeclaration>();
		
		for (DefaultDeclaration defaultDeclaration : defaultDeclarations)
		{
			if (defaultDeclaration.questionType() == referenceDeclaration.questionType())
			{
				returnList.add(defaultDeclaration);
			}
		}
		
		return returnList;
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{	
		gatherErrors(stylesheet.defaultDeclarations());
		
		for (Page page : stylesheet.pages())
		{
			page.accept(this);
		}
		
		return null;
	}
	
	@Override
	public QLSNode visit(Page page) 
	{
		gatherErrors(page.defaultDeclarations());
		
		for (Section section : page.sections())
		{
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(Section sectionDeclaration) 
	{
		gatherErrors(sectionDeclaration.defaultDeclarations());
		
		for (Section section : sectionDeclaration.sections())
		{
			section.accept(this);
		}
		
		return null;
	}

	@Override
	public QLSNode visit(WidgetDeclaration widgetDeclaration) 
	{
		assert(false);
		
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
