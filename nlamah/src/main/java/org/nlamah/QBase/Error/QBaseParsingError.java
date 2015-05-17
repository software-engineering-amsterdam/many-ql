package org.nlamah.QBase.Error;


public abstract class QBaseParsingError extends QBaseError 
{
	protected String valueString;
	protected int startLine;
	protected int startCharacterInLine;

	protected int startIndex;
	protected int stopIndex;

	public QBaseParsingError(int startIndex, int stopIndex)
	{
		super();

		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	public QBaseParsingError(String valueString, int startLine, int startCharacterInLine)
	{
		super();

		this.valueString = valueString;
		this.startLine = startLine;
		this.startCharacterInLine = startCharacterInLine;
	}
}
