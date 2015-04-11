package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ElseThenBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ElseThenBlockView;

public class ElseThenBlockViewController extends FormElementViewController 
{
	private ElseThenBlockView elseThenBlockView;
	
	public ElseThenBlockViewController(ElseThenBlock elseThenBlock) 
	{
		super(elseThenBlock);
		
		elseThenBlockView  = new ElseThenBlockView(this);
		
		setView(elseThenBlockView);
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub

	}

}
