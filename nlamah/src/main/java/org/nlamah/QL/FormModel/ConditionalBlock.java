package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.ConditionalBlockViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class ConditionalBlock extends FormElement 
{	
	private IfThenBlock ifThenBlock;
	private ArrayList<ElseIfThenBlock> elseIfThenBlocks;
	private ElseThenBlock elseThenBlock;
	
	public ConditionalBlock(IfThenBlock ifThenBlock, ArrayList<ElseIfThenBlock> elseIfThenBlocks, ElseThenBlock elseThenBlock) 
	{
		this.ifThenBlock = ifThenBlock;
		this.elseIfThenBlocks = elseIfThenBlocks;
		this.elseThenBlock = elseThenBlock;
	}

	public String toParseTreeString()
	{	
		String stringToReturn = "(" + this.getIdentifier() + " ";
		
		stringToReturn += ifThenBlock.toParseTreeString();
		
		if (elseIfThenBlocks != null)
		{
			for (int i = 0; i < elseIfThenBlocks.size(); i++)
			{
				stringToReturn += " " + elseIfThenBlocks.get(i).toParseTreeString();
			}
		}
		
		if (elseThenBlock != null)
		{
			stringToReturn += " " + elseThenBlock.toParseTreeString();
		}
		
		stringToReturn += " endif)";
		
		return stringToReturn;
	}

	@Override
	public FormElementViewController createViewController() 
	{
		return new ConditionalBlockViewController(this);
	}
}
