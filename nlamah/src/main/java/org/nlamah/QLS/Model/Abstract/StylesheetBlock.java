package org.nlamah.QLS.Model.Abstract;

import java.util.List;

import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;

public abstract class StylesheetBlock extends QLSNode
{
	protected DeclarationValue title;
	protected List<DefaultBlock> defaultBlocks;

	public StylesheetBlock(DeclarationValue title, List<DefaultBlock> defaultBlocks)
	{
		super();

		this.title = title;
		this.defaultBlocks = defaultBlocks;
		
		if (title != null)
		{
			title.setParentNode(this);
		}
		
		if (QBaseHelper.arrayExistsAndHasElements(defaultBlocks))
		{
			for (DefaultBlock defaultBlock : defaultBlocks)
			{
				defaultBlock.setParentNode(this);
			}
		}
	}



	public StylesheetBlock()
	{
		this(null, null);
	}

	public String title()
	{
		return title.toString();
	}

	public List<DefaultBlock> defaultBlocks()
	{		
		return defaultBlocks;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (this == object)
		{
			return true;
		}

		if (!(object instanceof StylesheetBlock))
		{
			return false;
		}

		StylesheetBlock value = (StylesheetBlock) object;

		if (this.title == null && value.title == null)
		{
			return true;
		}

		if (!(this.title.equals(value.title)))
		{
			return false;
		}

		if (!(this.defaultBlocks.equals(value.defaultBlocks)))
		{
			return false;
		}

		return true;
	}
}
