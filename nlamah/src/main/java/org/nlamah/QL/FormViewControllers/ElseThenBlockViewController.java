package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ElseThenBlock;
import org.nlamah.QL.FormModel.FormElement;

public class ElseThenBlockViewController extends FormElementViewController 
{
	private ElseThenBlock elseThenBlock;
	
	public ElseThenBlockViewController(ElseThenBlock elseThenBlock) 
	{
		super();
		
		this.elseThenBlock = elseThenBlock;
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub

	}

}
