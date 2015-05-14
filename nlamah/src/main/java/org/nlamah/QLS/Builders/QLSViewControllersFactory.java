package org.nlamah.QLS.Builders;

import java.util.List;

import org.nlamah.QL.Builders.QLViewControllersFactory;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.FormRootViewController;
import org.nlamah.QLS.Helper.QLSHelper;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class QLSViewControllersFactory extends QLViewControllersFactory 
{
	private Stylesheet stylesheet;
	
	public QLSViewControllersFactory(FormRootViewController rootViewController, Stylesheet stylesheet) 
	{
		super(rootViewController);
		
		this.stylesheet = stylesheet;
	}
	
	private boolean createNewViewController(FormQuestion question)
	{
		List<StyledQuestion> styledQuestions = QLSHelper.getQuestionsWithIdentifier(stylesheet.questions(), new IdentifierValue(question.identifier().toString()));
		
		assert(styledQuestions.size() == 1);
		
		WidgetDeclaration widgetDeclaration = styledQuestions.get(0).styleBlock().widgetDeclaration();
		
		if (widgetDeclaration != null)
		{
			currentlyCreatedViewController = new StyledQuestionViewControllerFactory().createViewController(question, widgetDeclaration.widget());
			
			currentlyCreatedViewController.setRootViewController(rootViewController);
			
			return true;
		}
		
		return false;
	}

	
	@Override
	public void visit(BooleanQuestion booleanQuestion) 
	{		
		if (!createNewViewController(booleanQuestion))
		{
			super.visit(booleanQuestion);
		}
	}
	
	@Override
	public void visit(NumberQuestion numberQuestion)
	{
		if (!createNewViewController(numberQuestion))
		{
			super.visit(numberQuestion);
		}
	}
	
	@Override
	public void visit(TextQuestion textQuestion)
	{
		if (!createNewViewController(textQuestion))
		{
			super.visit(textQuestion);
		}
	}
}
