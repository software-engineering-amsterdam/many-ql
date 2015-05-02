package org.nlamah.QBase.Error;


public class IllegalNumberError extends QBaseParsingError
{
	public IllegalNumberError(String valueString, int startLine, int startCharacterInLine) 
	{
		super(valueString, startLine, startCharacterInLine);
	}

	@Override
	public String description() 
	{
		String errorString = "ERROR: Line:" + startLine + ":" + startCharacterInLine;
		
		errorString += " The string: \"" + valueString + "\"  isn't a number or the number is negative.";
		
		return errorString;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {		 
		 if (!(object instanceof IllegalNumberError))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
