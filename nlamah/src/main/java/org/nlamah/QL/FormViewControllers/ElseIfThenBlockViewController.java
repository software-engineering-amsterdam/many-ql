package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ElseIfThenBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ElseIfThenBlockView;

public class ElseIfThenBlockViewController extends FormElementViewController 
{
	private ElseIfThenBlockView elseIfThenBlockView;
	
	private int preferredViewHeight;
	
	public ElseIfThenBlockViewController(ElseIfThenBlock elseIfThenBlock) 
	{
		super(elseIfThenBlock);
		
		elseIfThenBlockView = new ElseIfThenBlockView(this);
		
		setView(elseIfThenBlockView);
	}
	
	public boolean viewShouldBeVisisble()
	{
		return false;
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public int preferredViewHeight() 
	{
		return preferredViewHeight;
	}

	@Override
	public void viewNeedsUpdate() {
		// TODO Auto-generated method stub
		
	}

}
