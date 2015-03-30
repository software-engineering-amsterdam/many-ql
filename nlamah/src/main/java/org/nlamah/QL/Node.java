package org.nlamah.QL;

public abstract class Node {
	
	private String identifier;

	public Node(String identifier) {
		super();
		this.identifier = identifier;
	}


	public abstract String toParseTreeString();
	
	public String getIdentifier()
	{
		return this.identifier;
	}
}
