package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ElseThenBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ElseThenBlockView;

public class ElseThenBlockViewController extends FormElementViewController 
{
	private ElseThenBlock elseThenBlock;
	
	public ElseThenBlockViewController(ElseThenBlock elseThenBlock) 
	{
		super(elseThenBlock);
		
		this.elseThenBlock = elseThenBlock;
		
		setView(new ElseThenBlockView(elseThenBlock));
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub

	}

}
