package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViewControllers.BooleanQuestionViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class BooleanQuestion extends Question 
{
	private String type;
	private String label;

	private boolean checked;
	
	public BooleanQuestion(String identifier, String questionString, String type) 
	{
		super(identifier, questionString, type);
	}

	public String toParseTreeString()
	{	
		return "(question " + this.getIdentifier() + " " + this.type + " \""+ this.label + "\"" + ")";
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
	public FormElementViewController createViewController() 
	{
		return new BooleanQuestionViewController(this);
	}
}
