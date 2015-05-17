package org.nlamah.QBase.Error;


public class ContextSensitivityError extends QBaseParsingError 
{
	public ContextSensitivityError(int startIndex, int stopIndex) 
	{
		super(startIndex, stopIndex);
	}

	@Override
	public String description() 
	{
		return "ContextSensitivityError: StartIndex:" + startIndex + ", StopIndex:" + stopIndex;
	}	

	@Override 
	public boolean equals(Object object) 
	{		 
		if (!(object instanceof ContextSensitivityError))
		{
			return false;
		}

		return true;
	}	
}
