package org.nlamah.QL.Error.Parsing;

import org.nlamah.QL.Error.Abstract.ParsingError;

public class FileReadError extends ParsingError 
{
	private String fileName;

	public FileReadError(String fileName)
	{
		this.fileName = fileName;
	}
	
	@Override
	public String description() 
	{
		return "ERROR: The file with name: \"" + fileName + "\" couldn't be openend";
	}
}
