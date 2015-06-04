package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Helper.QLSHelper;
import org.nlamah.QLS.Interfaces.QLSVisitorAbstract;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

public class QuestionStyleCombiner extends QLSVisitorAbstract
{
	Stack<List<DefaultBlock>> styleStack;
	Form form;
	Stylesheet stylesheet;

	StyledQuestion currentQuestion;

	public QuestionStyleCombiner(Form form, Stylesheet stylesheet)
	{
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
		QBaseQuestionType styledQuestionType = QLSHelper.getTypeForStyledQuestion(styledQuestion, form.questions());

		StyleBlock styleBlockToAdd = new StyleBlock(new ArrayList<StyleDeclaration>());

		while(!styleStack.isEmpty())
		{
			List<DefaultBlock> defaultBlocks = styleStack.pop();

			DefaultBlock defaultBlockAll = QLSHelper.findStyleDeclarationOfType(null, defaultBlocks);

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

			if (styledQuestion.styleBlock() != null)
			{
				for (StyleDeclaration styleDeclaration : styledQuestion.styleBlock().styleDeclarations())
				{
					styleBlockToAdd.overWriteStyleDeclaration(styleDeclaration);
				}
			}
		}

		styledQuestion.setSyleBlock(styleBlockToAdd);
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
}