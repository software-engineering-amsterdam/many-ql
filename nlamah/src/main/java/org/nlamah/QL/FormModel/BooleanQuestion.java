package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViews.BooleanQuestionView;
import org.nlamah.QL.FormViews.FormElementView;

public class BooleanQuestion extends Question 
{
	private String type;
	private String label;

	public BooleanQuestion(String identifier, String questionString, String type) 
	{
		super(identifier, questionString, type);
	
	}

	public String toParseTreeString()
	{	
		return "(question " + this.getIdentifier() + " " + this.type + " \""+ this.label + "\"" + ")";
	}

	@Override
	public FormElementView createView() 
	{
		return new BooleanQuestionView(this);
	}
}
