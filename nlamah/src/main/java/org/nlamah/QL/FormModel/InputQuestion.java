package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViewControllers.BooleanQuestionViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class InputQuestion extends Question 
{
	private boolean checked;
	
	public InputQuestion(String identifier, String questionString, String type) 
	{
		super(identifier, questionString, type);
	}

	public boolean isChecked()
	{
		return checked;
	}
	
	public void setChecked(boolean checked)
	{
		this.checked = checked;
	}

	@Override
	protected FormElementViewController createViewController() 
	{
		return new BooleanQuestionViewController(this);
	}
}
