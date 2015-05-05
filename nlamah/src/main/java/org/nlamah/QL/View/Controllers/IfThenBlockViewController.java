package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QL.Builders.FormHeightAdjuster;
import org.nlamah.QL.Helper.QLHelper;
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
	public int neededViewHeight() 
	{
		FormHeightAdjuster heightAdjuster = new FormHeightAdjuster();
		
		int neededHeight = heightAdjuster.getPreferredHeight(childViewControllers());
		
		view.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		
		return neededHeight;
	}
}
