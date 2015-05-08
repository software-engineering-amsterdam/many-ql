package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Helper.QLSHelper;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
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

public class CombinedStylesForQuestionsBuilder implements QLSNodeVisitor
{
	Stack<List<DefaultBlock>> styleStack;
	Form form;
	Stylesheet stylesheet;

	StyledQuestion currentQuestion;

	public CombinedStylesForQuestionsBuilder(Form form, Stylesheet stylesheet)
	{
		super();

		this.form = form;
		this.stylesheet = stylesheet;
		
		styleStack = new Stack<List<DefaultBlock>>();
	}

	public void build()
	{
		for (StyledQuestion question : stylesheet.questions())
		{
			question.accept(this);
		}
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{
		styleStack.push(stylesheet.defaultBlocks());

		addStyleBlockToStyledQuestion(currentQuestion);

		return null;
	}

	private void addStyleBlockToStyledQuestion(StyledQuestion styledQuestion)
	{
		QBaseQuestionType styledQuestionType = QLSHelper.getTypeForStyleQuestion(styledQuestion, form.questions());

		DefaultBlock styleBlockToAdd = new DefaultBlock(styledQuestionType, new ArrayList<StyleDeclaration>());

		while(!styleStack.isEmpty())
		{
			List<DefaultBlock> defaultBlocks = styleStack.pop();

			DefaultBlock defaultBlockAll = QLSHelper.findStyleDeclarationOfType(QBaseQuestionType.ALL, defaultBlocks);

			if (defaultBlockAll != null)
			{
				for (StyleDeclaration styleDeclaration : defaultBlockAll.styleDeclarations())
				{
					styleBlockToAdd.overWriteStyleDeclaration(styleDeclaration);
				}
			}

			DefaultBlock defaultBlockTyped = QLSHelper.findStyleDeclarationOfType(styledQuestionType, defaultBlocks);

			if (defaultBlockTyped != null)
			{
				for (StyleDeclaration styleDeclaration : defaultBlockTyped.styleDeclarations())
				{
					styleBlockToAdd.overWriteStyleDeclaration(styleDeclaration);
				}
			} 

			if (styledQuestion.widgetDeclaration() != null)
			{
				styleBlockToAdd.overWriteStyleDeclaration(styledQuestion.widgetDeclaration());
			}
		}

		styledQuestion.styleBlock = styleBlockToAdd;
	}

	@Override
	public QLSNode visit(Page page) 
	{
		styleStack.push(page.defaultBlocks());

		page.parentNode().accept(this);

		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{	
		styleStack.push(section.defaultBlocks());

		section.parentNode().accept(this);

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
		currentQuestion = styledQuestion;
		
		styledQuestion.parentNode().accept(this);

		return null;
	}

	@Override
	public QLSNode visit(DefaultBlock defaultBlock) 
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
