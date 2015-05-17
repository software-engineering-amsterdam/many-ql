package org.nlamah.QBase.Error;


public class EnumRecognitionError extends QBaseParsingError 
{
	public EnumRecognitionError(String enumString, int startLine, int startCharacterInLine)
	{
		super(enumString, startLine, startCharacterInLine);
	}

	@Override
	public String description() 
	{
		String errorString = "ERROR: Line:" + startLine + ":" + startCharacterInLine;

		errorString += " The string: \"" + valueString + "\" coundn't be parsed to the enum LiteralValue: (boolean, text, number)";

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{		 
		if (!(object instanceof EnumRecognitionError))
		{
			return false;
		}

		return true;
	}
}
