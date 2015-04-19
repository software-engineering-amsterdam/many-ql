package org.nlamah.QL.ViewControllers.Form;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;

public class ElseIfThenBlockViewController extends DeclaringFormElementViewController 
{
	private ElseIfThenBlockView elseIfThenBlockView;
	
	public ElseIfThenBlockViewController(ElseIfThenBlock elseIfThenBlock) 
	{
		super(elseIfThenBlock);
		
		elseIfThenBlockView = new ElseIfThenBlockView(this);
		
		view = elseIfThenBlockView;
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
	public void viewNeedsUpdate() 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}

}
