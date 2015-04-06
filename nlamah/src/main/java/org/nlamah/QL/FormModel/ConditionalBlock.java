package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Conditional.ElseIfThenNode;
import org.nlamah.QL.Conditional.ElseThenNode;
import org.nlamah.QL.Conditional.IfThenNode;

public class ConditionalBlock extends FormElement 
{	
	IfThenNode ifThenNode;
	ArrayList<ElseIfThenNode> elseIfThenNodes;
	ElseThenNode elseThenNode;
	
	public ConditionalBlock(IfThenNode ifThenNode,
			ArrayList<ElseIfThenNode> elseIfThenNodes, ElseThenNode elseThenNode) 
	{
		this.ifThenNode = ifThenNode;
		this.elseIfThenNodes = elseIfThenNodes;
		this.elseThenNode = elseThenNode;
	}

	public String toParseTreeString()
	{	
		String stringToReturn = "(" + this.getIdentifier() + " ";
		
		stringToReturn += ifThenNode.toParseTreeString();
		
		if (elseIfThenNodes != null)
		{
			for (int i = 0; i < elseIfThenNodes.size(); i++)
			{
				stringToReturn += " " + elseIfThenNodes.get(i).toParseTreeString();
			}
		}
		
		if (elseThenNode != null)
		{
			stringToReturn += " " + elseThenNode.toParseTreeString();
		}
		
		stringToReturn += " endif)";
		
		return stringToReturn;
	}
}
