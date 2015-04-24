package org.nlamah.QL.Model.Error.Parsing;

import org.nlamah.QL.Model.Error.Abstract.ParsingError;

public class SyntaxError extends ParsingError 
{
	private int lineNumber;
	private int characterPosition;
	
	private String message;
	
	
	public SyntaxError(int lineNumber, int characterPosition, String message)
	{
		super();
		
		this.lineNumber = lineNumber;
		this.characterPosition = characterPosition;
		
		this.message = message;
	}
	
	@Override
	public String description() 
	{
		return "SyntaxError: Line:" + lineNumber + ":" + characterPosition + ", " + message;
	}
}
