package org.nlamah.QLS.Model.Abstract;

import java.util.List;

import org.nlamah.QBase.Tools.ArrayTools;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;

public abstract class StylesheetBlock extends QLSNode
{
	protected String title;
	protected List<DefaultBlock> defaultBlocks;

	public StylesheetBlock(String title, List<DefaultBlock> defaultBlocks)
	{
		this.title = title;
		this.defaultBlocks = defaultBlocks;

		if (ArrayTools.arrayExistsAndHasElements(defaultBlocks))
		{
			for (DefaultBlock defaultBlock : defaultBlocks)
			{
				defaultBlock.setParentNode(this);
			}
		}
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
	
	@Override
	public int hashCode()
	{
		if (title == null)
		{
			return 0;
		}
		
		return title.hashCode();
	}
}