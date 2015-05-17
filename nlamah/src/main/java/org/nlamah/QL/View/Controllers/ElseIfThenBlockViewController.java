package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QL.Builders.FormHeightAdjuster;
import org.nlamah.QL.Helper.QLHelper;
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
	public int neededViewHeight() 
	{
		FormHeightAdjuster heightCalculator = new FormHeightAdjuster();
		
		int neededHeight = heightCalculator.getPreferredHeight(childViewControllers());
		
		view.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		
		return neededHeight;
	}
}
