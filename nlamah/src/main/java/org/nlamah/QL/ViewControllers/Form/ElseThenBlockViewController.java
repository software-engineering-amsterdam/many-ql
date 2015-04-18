package org.nlamah.QL.ViewControllers.Form;

import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.ParentingFormElementViewController;
import org.nlamah.QL.Views.Form.ElseThenBlockView;

public class ElseThenBlockViewController extends ParentingFormElementViewController 
{
	private ElseThenBlockView elseThenBlockView;
	
	private int preferredViewHeight;
	
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
	public int preferredViewHeight() 
	{
		return preferredViewHeight;
	}

	@Override
	public void viewNeedsUpdate() {
		// TODO Auto-generated method stub
		
	}

}
