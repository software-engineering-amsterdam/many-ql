package org.nlamah.QL.Expression;

import org.nlamah.QL.Node;

public class Expression extends Node{

	protected String expressionString;
	
	public Expression(String identifier, String expressionString) {
		super(identifier);
		this.expressionString = expressionString;
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
