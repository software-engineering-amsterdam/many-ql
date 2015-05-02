package org.nlamah.QBase.Error;


public class SyntaxError extends QBaseParsingError 
{
	private String message;
	
	public SyntaxError(int startLine, int startCharacterInLine, String message)
	{
		super("", startLine, startCharacterInLine);
		
		this.message = message;
	}
	
	@Override
	public String description() 
	{
		return "SyntaxError: Line:" + startLine + ":" + startCharacterInLine + ", " + message;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {		 
		 if (!(object instanceof SyntaxError))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
