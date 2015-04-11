package org.nlamah.QL.Expression;

public class NotExpression extends LogicalExpression {

	LogicalExpression logicalExpression;
	
	public NotExpression(LogicalExpression logicalExpression) 
	{
		super(logicalExpression);
		
		this.logicalExpression = logicalExpression;
	}
	
	@Override
	public String toParseTreeString()
	{
		String stringToReturn = "(" + identifier() + " ! " + this.logicalExpression.toParseTreeString() + ")";
		return stringToReturn;
	}

}
