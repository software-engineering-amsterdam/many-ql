package org.nlamah.QL.ViewControllers.Form;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Form.ElseThenBlockView;

public class ElseThenBlockViewController extends DeclaringFormElementViewController 
{
	private ElseThenBlockView elseThenBlockView;
	
	public ElseThenBlockViewController(ElseThenBlock elseThenBlock) 
	{
		super(elseThenBlock);
		
		elseThenBlockView  = new ElseThenBlockView(this);
		
		view = elseThenBlockView;
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
