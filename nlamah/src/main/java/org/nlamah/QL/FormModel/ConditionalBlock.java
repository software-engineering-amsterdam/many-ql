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
		super();
		
		this.ifThenBlock = ifThenBlock;
		this.elseIfThenBlocks = elseIfThenBlocks;
		this.elseThenBlock = elseThenBlock;
	}
	
	public IfThenBlock ifThenBlock()
	{
		return this.ifThenBlock;
	}
	
	public ArrayList<ElseIfThenBlock> elseIfThenBlocks()
	{
		return this.elseIfThenBlocks;
	}
	
	public ElseThenBlock elseThenBlock()
	{
		return this.elseThenBlock;
	}

	@Override
	protected FormElementViewController createViewController() 
	{
		return new ConditionalBlockViewController(this);
	}
}
