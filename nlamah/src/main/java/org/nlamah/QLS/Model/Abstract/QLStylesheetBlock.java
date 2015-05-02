package org.nlamah.QLS.Model.Abstract;

import java.util.List;

import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;

public abstract class QLStylesheetBlock extends QLSNode 
{
	protected DeclarationValue title;
	protected List<? extends QLStylesheetBlock> childBlocks;
	protected List<DefaultDeclaration> defaultDeclarations;
	
	public QLStylesheetBlock(DeclarationValue title, List<? extends QLStylesheetBlock> childBlocks, List<DefaultDeclaration> defaultDeclarations)
	{
		super();
		
		this.title = title;
		this.childBlocks = childBlocks;
		this.defaultDeclarations = defaultDeclarations;
		
		title.setParentNode(this);
		
		for (QLStylesheetBlock childBlock : childBlocks)
		{
			childBlock.setParentNode(this);
		}
		
		for (DefaultDeclaration defaultDeclaration : defaultDeclarations)
		{
			defaultDeclaration.setParentNode(this);
		}
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof QLStylesheetBlock))
		 {
			 return false;
		 }
		 
		 QLStylesheetBlock value = (QLStylesheetBlock) object;
		 
		 if (this.title == null && value.title == null)
		 {
			 return true;
		 }
		 
		 if (!(this.title.equals(value.title)))
		 {
			 return false;
		 }
		 
		 if (!(this.childBlocks.equals(value.childBlocks)))
		 {
			 return false;
		 } 
		 
		 if (!(this.defaultDeclarations.equals(value.defaultDeclarations)))
		 {
			 return false;
		 }

		 return true;
	 }
}
