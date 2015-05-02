package org.nlamah.QBase.Error;


public class HexNumberRecognitionError extends QBaseParsingError 
{

	public HexNumberRecognitionError(String valueString, int startLine, int startCharacterInLine) 
	{
		super(valueString, startLine, startCharacterInLine);
	}

	@Override
	public String description() 
	{
		String errorString = "ERROR: Line:" + startLine + ":" + startCharacterInLine;
		
		errorString += " The string: \"" + valueString + "\" coundn't be parsed to the valid color.";
		
		return errorString;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {		 
		 if (!(object instanceof HexNumberRecognitionError))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
