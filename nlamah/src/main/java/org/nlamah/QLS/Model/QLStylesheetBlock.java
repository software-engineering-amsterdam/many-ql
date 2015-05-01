package org.nlamah.QLS.Model;

import java.util.List;

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
}
