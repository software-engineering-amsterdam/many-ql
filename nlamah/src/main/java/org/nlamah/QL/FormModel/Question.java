package org.nlamah.QL.FormModel;

public abstract class Question extends FormElement 
{
	private String identifier;
	private String type;
	private String questionString;
	
	public Question(String identifier, String questionString, String type) 
	{
		super();
		
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
	public String toParseTreeString() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
