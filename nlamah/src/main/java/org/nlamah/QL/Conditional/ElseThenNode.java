package org.nlamah.QL.Conditional;

import java.util.ArrayList;

import org.nlamah.QL.Form.FormElement;

public class ElseThenNode extends ConditionalBlockNode {
	
	public ElseThenNode(ArrayList<FormElement> formElements) {
		super("elsethen", null, formElements);
		
	}

	@Override
	public String toParseTreeString() {
		
		String stringToReturn = "(" + this.getIdentifier() + " ";
		stringToReturn += "else ";
		stringToReturn += this.formElementsToParseTreeString();
		stringToReturn += ")";
		return stringToReturn;
	}
}
