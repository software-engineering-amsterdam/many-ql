package org.nlamah.QLS.TypeChecker;

import java.util.List;

import org.nlamah.QLS.Error.DoublePropertyDeclarationError;
import org.nlamah.QLS.Helper.QLSHelper;
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
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class DoublePropertyDeclarationChecker extends QLSTypeChecker implements QLSNodeVisitor
{	
	public DoublePropertyDeclarationChecker(Stylesheet stylesheet)
	{
		super();

		stylesheet.accept(this);
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
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion styledQuestion) 
	{
		styledQuestion.styleBlock().accept(this);

		return null;
	}

	@Override
	public QLSNode visit(DefaultBlock defaultBlock) 
	{
		for (StyleDeclaration styleDeclaration : defaultBlock.styleDeclarations())
		{
			List<StyleDeclaration> foundDeclarations = QLSHelper.findStyleDeclarationsOfTheSameClass(styleDeclaration, defaultBlock.styleDeclarations());

			if (foundDeclarations.size() > 1)
			{
				errors.add(new DoublePropertyDeclarationError(foundDeclarations));
			}
		}

		return null;
	}

	@Override
	public QLSNode visit(StyleBlock styleBlock) 
	{
		for (StyleDeclaration styleDeclaration : styleBlock.styleDeclarations())
		{
			System.out.println("styleBlock:" + styleDeclaration.getClass());

			List<StyleDeclaration> foundDeclarations = QLSHelper.findStyleDeclarationsOfTheSameClass(styleDeclaration, styleBlock.styleDeclarations());

			if (foundDeclarations.size() > 1)
			{
				errors.add(new DoublePropertyDeclarationError(foundDeclarations));
			}
		}

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
