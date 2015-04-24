package org.nlamah.QL.Model.Error.Parsing;

import org.nlamah.QL.Model.Error.Abstract.ParsingError;

public class EnumRecognitionError extends ParsingError 
{
	private String enumString;
	private int startLine;
	private int startCharacterInLine;
	
	public EnumRecognitionError(String enumString, int startLine, int startCharacterInLine)
	{
		super();
		
		this.enumString = enumString;
		this.startLine = startLine;
		this.startCharacterInLine = startCharacterInLine;
	}
		
	@Override
	public String description() 
	{
		String errorString = "ERROR: Line:" + startLine + ":" + startCharacterInLine;
		
		errorString += " The string: \"" + enumString + "\" coundn't be parsed to the enum LiteralValue: (boolean, text, number)";
		
		return errorString;
	}

}
