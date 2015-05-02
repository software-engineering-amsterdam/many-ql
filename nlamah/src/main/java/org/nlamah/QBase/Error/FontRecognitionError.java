package org.nlamah.QBase.Error;

public class FontRecognitionError extends QBaseParsingError 
{

	public FontRecognitionError(String valueString, int startLine, int startCharacterInLine) 
	{
		super(valueString, startLine, startCharacterInLine);
	}

	@Override
	public String description() 
	{
		String errorString = "ERROR: Line:" + startLine + ":" + startCharacterInLine;
		
		errorString += " The string: \"" + valueString + "\" coundn't be parsed to the valid font.";
		
		return errorString;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {		 
		 if (!(object instanceof FontRecognitionError))
		 {
			 return false;
		 }
		 
		 return true;
	 }	
}
