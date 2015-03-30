package org.nlamah.QL.Conditional;

import java.util.ArrayList;

import org.nlamah.QL.Expression.LogicalExpression;
import org.nlamah.QL.Form.FormElement;


public class ElseIfThenNode extends ConditionalBlockNode {
	
	public ElseIfThenNode(LogicalExpression logicalExpression,
			ArrayList<FormElement> formElements) {
		super("elsifthen", logicalExpression, formElements);
	}
	
	@Override
	public String toParseTreeString() {
		
		String stringToReturn = "(" + this.getIdentifier() + " ";
		stringToReturn += "elsif ( " + this.logicalExpression.toParseTreeString() + " ) ";
		stringToReturn += this.formElementsToParseTreeString();
		stringToReturn += ")";
		return stringToReturn;
	}
}
