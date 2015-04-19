package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class ConditionalBlock extends FormElement 
{	
	private IfThenBlock ifThenBlock;
	private ArrayList<ElseIfThenBlock> elseIfThenBlocks;
	private ElseThenBlock elseThenBlock;
	
	public ConditionalBlock(IfThenBlock ifThenBlock, ArrayList<ElseIfThenBlock> elseIfThenBlocks, ElseThenBlock elseThenBlock) 
	{
		super(null);
		
		this.ifThenBlock = ifThenBlock;
		this.elseIfThenBlocks = elseIfThenBlocks;
		this.elseThenBlock = elseThenBlock;
		
		setParentElements();
	}
	
	private void setParentElements()
	{
		if (ifThenBlock != null)
		{
			ifThenBlock.setParentNode(this);
		}
		
		if (Helper.arrayExistsAndHasElements(elseIfThenBlocks))
		{
			for (ElseIfThenBlock elseIfThenBlock : elseIfThenBlocks)
			{
				elseIfThenBlock.setParentNode(this);
			}
		}
		
		if (elseThenBlock != null)
		{
			elseThenBlock.setParentNode(this);
		}
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
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof ConditionalBlock))
		 {
			 return false;
		 }
		 
		 ConditionalBlock value = (ConditionalBlock)object;
		 
		 if (!(this.ifThenBlock.equals(value.ifThenBlock)))
		 {
			 return false;
		 }
		 
		 if (!(this.elseIfThenBlocks.equals(value.elseIfThenBlocks)))
		 {
			 return false;
		 }
		 
		 if (this.elseThenBlock == null && value.elseThenBlock == null)
		 {
			 return true;
		 }
		 //TODO what when the are not both of them equal
		 
		 if (!(this.elseThenBlock.equals(value.elseThenBlock)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);	
	}
}
