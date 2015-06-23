package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Builders.FormHeightEvaluator;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.View.Controllers.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.View.Form.ElseIfThenBlockView;

public class ElseIfThenBlockViewController extends DeclaringFormElementViewController 
{	
	public ElseIfThenBlockViewController(ElseIfThenBlock elseIfThenBlock) 
	{
		super(elseIfThenBlock);

		view = new ElseIfThenBlockView();
	}

	public boolean shouldBeVisisble()
	{
		return ((ElseIfThenBlock) modelElement).isSatisfied();
	}

	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}

	@Override
	public int evaluateViewHeight() 
	{
		FormHeightEvaluator heightCalculator = new FormHeightEvaluator();

		int neededHeight = heightCalculator.evaluate(childViewControllers());

		view.setPreferredSize(new Dimension(UIConstants.contentWidth(), neededHeight));

		return neededHeight;
	}
}