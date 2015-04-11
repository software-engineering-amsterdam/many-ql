package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViewControllers.BooleanQuestionViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class BooleanQuestion extends Question 
{
	private boolean checked;
	
	public BooleanQuestion(String identifier, String questionString, String type) 
	{
		super(identifier, questionString, type);
	}

	public String toParseTreeString()
	{	
		return "(question " + identifier() + " " + type() + " \""+ questionString() + "\"" + ")";
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
