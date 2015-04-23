package org.nlamah.QL.Error.Parsing;

import org.nlamah.QL.Error.Abstract.ParsingError;

public class AttemptingFullContextError extends ParsingError 
{
	private int startIndex;
	private int stopIndex;

	public AttemptingFullContextError(int startIndex, int stopIndex) 
	{
		super();
		
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	@Override
	public String description() 
	{
		return "AttemptingFullContextError: StartIndex:" + startIndex + ", StopIndex:" + stopIndex;
	}
}
