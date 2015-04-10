package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormViews.IfThenBlockView;

public class IfThenBlockViewController extends FormElementViewController 
{
	private IfThenBlock ifThenBlock;
	
	public IfThenBlockViewController(IfThenBlock ifThenBlock) 
	{
		super(ifThenBlock);
		
		this.ifThenBlock = ifThenBlock;
		
		setView(new IfThenBlockView(ifThenBlock));
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}
}
