package org.nlamah.QL.FormModel;


public class Question extends FormElement 
{
	private String type;
	private String label;

	public Question(String identifier, String type, String label) 
	{
		this.type = type;
		this.label = label;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getLabel()
	{
		return this.label;
	}

	public String toParseTreeString()
	{	
		return "(question " + this.getIdentifier() + " " + this.type + " \""+ this.label + "\"" + ")";
	}
	
}
