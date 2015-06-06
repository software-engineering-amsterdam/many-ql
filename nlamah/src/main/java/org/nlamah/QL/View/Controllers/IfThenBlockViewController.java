package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Builders.FormHeightEvaluator;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.View.Controllers.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.View.Form.IfThenBlockView;

public class IfThenBlockViewController extends DeclaringFormElementViewController 
{	
	public IfThenBlockViewController(IfThenBlock ifThenBlock) 
	{
		super(ifThenBlock);

		view = new IfThenBlockView();
	}

	public boolean viewShouldBeVisible()
	{
		return ((IfThenBlock) modelElement).isSatisfied();
	}

	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}

	@Override
	public int evaluateViewHeight() 
	{
		FormHeightEvaluator heightAdjuster = new FormHeightEvaluator();

		int neededHeight = heightAdjuster.evaluate(childViewControllers());

		view.setPreferredSize(new Dimension(UIConstants.contentWidth(), neededHeight));

		return neededHeight;
	}
}