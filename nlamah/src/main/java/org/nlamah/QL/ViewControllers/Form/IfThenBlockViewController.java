package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Builders.FormHeightAdjuster;
import org.nlamah.QL.Views.Form.IfThenBlockView;

public class IfThenBlockViewController extends DeclaringFormElementViewController 
{
	private IfThenBlockView ifThenBlockView;
	
	public IfThenBlockViewController(IfThenBlock ifThenBlock) 
	{
		super(ifThenBlock);
		
		ifThenBlockView = new IfThenBlockView(this);
		
		view = ifThenBlockView;
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
		FormHeightAdjuster heightCalculator = new FormHeightAdjuster();
		
		int neededHeight = heightCalculator.getPreferredHeight(childViewControllers());
		
		ifThenBlockView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		
		return neededHeight;
	}
}
