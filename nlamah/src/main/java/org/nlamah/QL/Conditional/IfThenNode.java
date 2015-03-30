package org.nlamah.QL.Conditional;

import java.util.ArrayList;

import org.nlamah.QL.Expression.LogicalExpression;
import org.nlamah.QL.Form.FormElement;

public class IfThenNode extends ConditionalBlockNode {

	public IfThenNode(LogicalExpression logicalExpression,
			ArrayList<FormElement> formElements) {
		super("ifthen", logicalExpression, formElements);
	}

	@Override
	public String toParseTreeString() {
		
		String stringToReturn = "(" + this.getIdentifier() + " ";
		stringToReturn += "if ( " + this.logicalExpression.toParseTreeString() + " ) "; 
		stringToReturn += this.formElementsToParseTreeString();
		stringToReturn += ")";
		return stringToReturn;
	}
}
