package org.nlamah.QLS.Builders;

import org.nlamah.QL.Builders.QLViewFactory;
import org.nlamah.QL.View.Controllers.BooleanQuestionViewController;
import org.nlamah.QL.View.Controllers.ComputedQuestionViewController;
import org.nlamah.QL.View.Controllers.NumberQuestionViewController;
import org.nlamah.QL.View.Controllers.TextQuestionViewController;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QL.View.Form.Abstract.FormElementView;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;

public class QLSViewFactory extends QLViewFactory 
{
	public FormElementView gatherViewForFormViewController(FormElementViewController formViewController, DefaultBlock styleBlock)
	{		
		formViewController.accept(this);

		return currentlyCreatedView;
	}
	
	@Override
	public void visit(BooleanQuestionViewController booleanQuestionViewController) 
	{
		super.visit(booleanQuestionViewController);
	}

	@Override
	public void visit(ComputedQuestionViewController computedQuestionViewController) 
	{
		super.visit(computedQuestionViewController);
	}

	@Override
	public void visit(NumberQuestionViewController numberQuestionViewController) 
	{
		super.visit(numberQuestionViewController);
	}

	@Override
	public void visit(TextQuestionViewController textQuestionViewController) 
	{
		super.visit(textQuestionViewController);
	}
}
