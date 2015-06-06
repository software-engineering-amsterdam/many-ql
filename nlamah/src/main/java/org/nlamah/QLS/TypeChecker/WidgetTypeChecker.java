package org.nlamah.QLS.TypeChecker;

import java.util.List;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Tools.QLSTools;
import org.nlamah.QBase.TypeChecker.QBaseAbstractTypeChecker;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.TypeChecker.FormQuestionsCollector;
import org.nlamah.QLS.Error.WidgetTypeMismatchError;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class WidgetTypeChecker extends QBaseAbstractTypeChecker implements QLSNodeVisitor
{
	private List<FormQuestion> formQuestions;
	private List<WidgetDeclaration> widgetDeclarations;

	private WidgetDeclaration currentWidgetDeclaration;

	public WidgetTypeChecker(Form form, Stylesheet stylesheet) 
	{
		formQuestions = new FormQuestionsCollector(form).questions();

		widgetDeclarations = new WidgetDeclarationsCollector(stylesheet).widgetDeclarations();	
	}

	public void check()
	{
		for (WidgetDeclaration widgetDeclaration : widgetDeclarations)
		{
			currentWidgetDeclaration = widgetDeclaration;

			widgetDeclaration.parentNode().accept(this);
		}
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(Page page) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{
		assert(false);
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
		QBaseQuestionType formQuestionType = QLSTools.getTypeForStyledQuestion(styledQuestion, formQuestions);

		if (formQuestionType != currentWidgetDeclaration.returnType())
		{
			errors.add(new WidgetTypeMismatchError(currentWidgetDeclaration, formQuestionType));
		}

		return null;
	}

	@Override
	public QLSNode visit(DefaultBlock defaultBlock) 
	{	
		if (defaultBlock.questionType() != currentWidgetDeclaration.returnType())
		{
			errors.add(new WidgetTypeMismatchError(currentWidgetDeclaration, currentWidgetDeclaration.returnType()));
		}

		return null;
	}

	@Override 
	public QLSNode visit(StyleBlock styleBlock)
	{
		styleBlock.parentNode().accept(this);

		return null;
	}

	@Override
	public QLSNode visit(IdentifierValue identifierValue) 
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