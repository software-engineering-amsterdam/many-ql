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
		this.valueString = null;
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	public QBaseParsingError(String valueString, int startLine, int startCharacterInLine)
	{
		this.valueString = valueString;
		this.startLine = startLine;
		this.startCharacterInLine = startCharacterInLine;
	}
	
	@Override
	public boolean equals(Object object)
	{
		if (!super.equals(object))
		{
			return false;
		}
		
		return true;
	}
}