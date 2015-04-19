package org.nlamah.QL.ViewControllers.Form;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
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
	
	public boolean viewShouldBeVisisble()
	{
		return ((IfThenBlock) modelElement).isSatisfied();
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
