package org.nlamah.QL.Question;

import org.nlamah.QL.Form.FormElement;

public class Question extends FormElement {

	String type;
	String label;

	public Question(String identifier, String type, String label) {
		super(identifier);
		this.type = type;
		this.label = label;
	}



	public String toParseTreeString()
	{	
		return "(question " + this.getIdentifier() + " " + this.type + " \""+ this.label + "\"" + ")";
	}
	
}
