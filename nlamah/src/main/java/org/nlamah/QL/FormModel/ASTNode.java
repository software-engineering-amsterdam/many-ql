package org.nlamah.QL.FormModel;

import java.util.ArrayList;

public abstract class ASTNode 
{	
	private ArrayList<ASTNode> relatedNodes;
	
	public ASTNode()
	{
		super();
	}
	
	public ArrayList<ASTNode> relatedNodes()
	{
		return this.relatedNodes;
	}
	
	public void addRelatedNode(ASTNode relatedNode)
	{
		if (relatedNodes == null)
		{
			relatedNodes = new ArrayList<ASTNode>();
		}
		
		relatedNodes.add(relatedNode);
	}
	
 	public abstract String toParseTreeString();
	
}
