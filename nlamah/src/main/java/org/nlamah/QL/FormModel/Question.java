package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViews.FormElementView;

public abstract class Question extends FormElement 
{
	private String identifier;
	private String type;
	private String questionString;
	
	public Question(String identifier, String questionString, String type) 
	{
		this.identifier = identifier;
		this.questionString = questionString;
		this.type = type;
	}
	
	public String identifier()
	{
		return identifier;
	}
	
	public String type()
	{
		return type;
	}
	
	public String questionString()
	{
		return questionString;
	}

	@Override
	public FormElementView createView() 
	{
		return null;
	}

	@Override
	public String toParseTreeString() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
