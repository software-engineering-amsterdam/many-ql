package org.nlamah.QLS.Builders;

import java.util.List;

import org.nlamah.QBase.Tools.QLSTools;
import org.nlamah.QL.Builders.QLViewControllersFactory;
import org.nlamah.QL.Model.Form.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.QuestionViewController;
import org.nlamah.QL.View.Form.Abstract.WidgetView;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.View.Controllers.RootFormViewControllerStyled;

public class QLSViewControllersFactory extends QLViewControllersFactory 
{
	private Stylesheet stylesheet;

	public QLSViewControllersFactory(RootFormViewControllerStyled rootViewController) 
	{
		super(rootViewController);

		this.stylesheet = rootViewController.stylesheet();
	}

	private boolean createNewViewController(FormQuestion question)
	{
		List<StyledQuestion> styledQuestions = QLSTools.getQuestionsWithIdentifier(stylesheet.questions(), new IdentifierValue(question.identifier().toString()));

		assert(styledQuestions.size() == 1);

		WidgetDeclaration widgetDeclaration = styledQuestions.get(0).styleBlock().widgetDeclaration();

		if (widgetDeclaration != null)
		{	
			QuestionViewController questionViewController = new QuestionViewController(rootViewController, question);

			WidgetView widgetView = WidgetViewFactory.widgetViewForStyle(widgetDeclaration);

			widgetView.setWidgetViewDelegate(questionViewController);

			questionViewController.setWidgetView(widgetView);

			currentlyCreatedViewController = questionViewController;

			return true;
		}

		return false;
	}

	@Override
	public void visit(InputQuestion inputQuestion)
	{
		if (!createNewViewController(inputQuestion))
		{
			super.visit(inputQuestion);
		}
	}
}
