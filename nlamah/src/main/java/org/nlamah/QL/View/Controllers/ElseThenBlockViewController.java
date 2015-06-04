package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QL.Builders.FormHeightEvaluator;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.View.Controllers.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.View.Form.ElseThenBlockView;

public class ElseThenBlockViewController extends DeclaringFormElementViewController 
{	
	public ElseThenBlockViewController(ElseThenBlock elseThenBlock) 
	{
		super(elseThenBlock);

		view = new ElseThenBlockView();
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

		view.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));

		return neededHeight;
	}
}