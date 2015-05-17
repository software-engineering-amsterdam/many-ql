package org.nlamah.QBase.Error;

public class AmbiguityError extends QBaseParsingError 
{
	public AmbiguityError(int startIndex, int stopIndex) 
	{
		super(startIndex, stopIndex);
	}

	@Override
	public String description() 
	{
		return "AmbiguityError: StartIndex:" + startIndex + ", StopIndex:" + stopIndex;
	}

	@Override 
	public boolean equals(Object object) 
	{	
		if (!super.equals(object))
		{
			return false;
		}
		
		if (!(object instanceof AmbiguityError))
		{
			return false;
		}

		return true;
	}	
}
