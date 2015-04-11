package org.nlamah.QL.Expression;

import org.nlamah.QL.FormModel.ASTNode;

public class Expression extends ASTNode{

	protected String identifier;
	protected String expressionString;
	
	public Expression(String identifier, String expressionString) 
	{
		super();
		
		this.identifier = identifier;
		this.expressionString = expressionString;
	}
	
	public String identifier()
	{
		return this.identifier;
	}

	@Override
	public String toString()
	{
		return expressionString;
	}
	
	@Override
	public String toParseTreeString() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
