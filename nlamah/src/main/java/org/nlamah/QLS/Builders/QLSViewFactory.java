package org.nlamah.QLS.Builders;

import org.nlamah.QL.Builders.QLViewFactory;
import org.nlamah.QL.View.Controllers.QuestionViewController;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QL.View.Form.Abstract.FormElementView;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.View.Stylesheet.QuestionViewStyled;

public class QLSViewFactory extends QLViewFactory 
{
	private StyleBlock styleBlock;
	
	public FormElementView gatherViewForFormViewController(FormElementViewController formViewController, StyleBlock styleBlock)
	{	
		this.styleBlock = styleBlock;
		
		formViewController.accept(this);
		
		return currentlyCreatedView;
	}
	
	@Override
	public void visit(QuestionViewController questionViewController)
	{
		assert(questionViewController.view() instanceof QuestionView);
		
		QuestionView questionView = (QuestionView) questionViewController.view();
		
		QuestionViewStyled questionViewStyled = new QuestionViewStyled(questionView, styleBlock);
		
		currentlyCreatedView = questionViewStyled;
	}
}
