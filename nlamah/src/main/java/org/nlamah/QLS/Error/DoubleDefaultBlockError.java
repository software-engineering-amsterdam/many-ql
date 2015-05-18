package org.nlamah.QLS.Error;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;

public class DoubleDefaultBlockError extends QBaseError 
{
	private List<DefaultBlock> defaultBlocks;

	public DoubleDefaultBlockError(List<DefaultBlock>defaultBlocks) 
	{
		this.defaultBlocks = defaultBlocks;
	}

	@Override
	public String description() 
	{			
		String errorString = "ERROR: Line " + defaultBlocks.get(0).startsOnLine + ":"  + defaultBlocks.get(0).startsAtCharacterPosition;

		errorString += ", The question with Identifier \"" + defaultBlocks.get(0).toString() + "\" is placed more than once in the stylesheet.<br/>";

		for (DefaultBlock defaultBlock : defaultBlocks)
		{
			errorString += "<div style='margin-left:45px'>See line: " + defaultBlock.startsOnLine + "<br/></div>";
		}

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof DoubleDefaultBlockError))
		{
			return false;
		}

		DoubleDefaultBlockError value = (DoubleDefaultBlockError) object;

		if (!this.defaultBlocks.equals(value.defaultBlocks))
		{
			return false;
		}

		return true;
	}
}