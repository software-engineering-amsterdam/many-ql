package org.nlamah.QL.Expression;
import org.nlamah.QL.Expression.Expression;

public class LogicalExpression extends Expression 
{
	
	public LogicalExpression(Expression expression){
		
		super("logical_expression", expression.toString());
	}
	
	@Override
	public String toParseTreeString() {
		
		String stringToReturn = "(" + identifier() + " ";
		stringToReturn += this.expressionString;
		stringToReturn += ")";
		return stringToReturn;
		
	}

}
