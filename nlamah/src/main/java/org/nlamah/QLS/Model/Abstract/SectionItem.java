package org.nlamah.QLS.Model.Abstract;

import java.util.List;

import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;

public abstract class SectionItem extends StylesheetBlock
{
	public SectionItem(String titleValue, List<DefaultBlock> defaultBlocks) 
	{
		super(titleValue, defaultBlocks);
	}

	public SectionItem()
	{
		this(null, null);
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof SectionItem))
		{
			return false;
		}

		return true;
	}
}
