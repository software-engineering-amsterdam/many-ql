package org.nlamah.QBase.Error;


public class AttemptingFullContextError extends QBaseParsingError 
{
	public AttemptingFullContextError(int startIndex, int stopIndex) 
	{
		super(startIndex, stopIndex);
	}

	@Override
	public String description() 
	{
		return "AttemptingFullContextError: StartIndex:" + startIndex + ", StopIndex:" + stopIndex;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {		 
		 if (!(object instanceof AttemptingFullContextError))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
