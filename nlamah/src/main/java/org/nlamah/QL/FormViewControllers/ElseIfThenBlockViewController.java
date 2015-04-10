package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ElseIfThenBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ElseIfThenBlockView;

public class ElseIfThenBlockViewController extends FormElementViewController 
{
	private ElseIfThenBlock elseIfThenBlock;
	
	public ElseIfThenBlockViewController(ElseIfThenBlock elseIfThenBlock) 
	{
		super();
		
		this.elseIfThenBlock = elseIfThenBlock;
		
		view = new ElseIfThenBlockView(elseIfThenBlock);
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

}
