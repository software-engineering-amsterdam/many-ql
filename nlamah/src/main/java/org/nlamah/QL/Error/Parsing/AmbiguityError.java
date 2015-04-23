package org.nlamah.QL.Error.Parsing;

import org.nlamah.QL.Error.Abstract.ParsingError;

public class AmbiguityError extends ParsingError 
{
	private int startIndex;
	private int stopIndex;

	public AmbiguityError(int startIndex, int stopIndex) 
	{
		super();
		
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	@Override
	public String description() 
	{
		return "AmbiguityError: StartIndex:" + startIndex + ", StopIndex:" + stopIndex;
	}
}
