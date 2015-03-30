package org.nlamah.QL.Expression;

public class ParenthisedLogicalExpression extends LogicalExpression {

	LogicalExpression logicalExpression;
	
	public ParenthisedLogicalExpression(LogicalExpression logicalExpression)
	{
		super(logicalExpression);
		this.logicalExpression = logicalExpression;
	}
	
	@Override
	public String toString()
	{
		return "(" + this.logicalExpression.toString() + ")";
	}
	
	@Override
	public String toParseTreeString() {
		
		String stringToReturn = "(logical_expression " + "( " +  this.logicalExpression.toParseTreeString() + " )" +  ")";
		return stringToReturn;
		
	}

}
