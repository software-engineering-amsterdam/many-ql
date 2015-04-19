package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;
import org.nlamah.QL.Visitors.FormHeightAdjuster;

public class ElseIfThenBlockViewController extends DeclaringFormElementViewController 
{
	private ElseIfThenBlockView elseIfThenBlockView;
	
	public ElseIfThenBlockViewController(ElseIfThenBlock elseIfThenBlock) 
	{
		super(elseIfThenBlock);
		
		elseIfThenBlockView = new ElseIfThenBlockView(this);
		
		view = elseIfThenBlockView;
	}
	
	public boolean shouldBeVisisble()
	{
		return ((ElseIfThenBlock) modelElement).isSatisfied();
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void viewNeedsUpdate() 
	{
		// TODO Auto-generated method stub	
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
		
		elseIfThenBlockView.setPreferredSize(new Dimension(Helper.contentWidth(), neededHeight));
		
		return neededHeight;
	}
}
