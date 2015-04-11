package org.nlamah.QL.Expression;

public class GreaterThanExpression extends LogicalExpression {

	LogicalExpression leftHandExpression;
	LogicalExpression rightHandExpression;
	
	public GreaterThanExpression(LogicalExpression leftHandExpression, LogicalExpression rightHandExpression) 
	{
		super(leftHandExpression);
		this.leftHandExpression = leftHandExpression;
		this.rightHandExpression = rightHandExpression;
	}
	
	public String toParseTreeString()
	{
		String stringToReturn = "(" + identifier() + " ";
		stringToReturn += leftHandExpression.toParseTreeString() + " > ";
		stringToReturn += rightHandExpression.toParseTreeString() + ")";
		return stringToReturn;
	}

	
}
