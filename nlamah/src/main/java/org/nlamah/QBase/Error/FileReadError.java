package org.nlamah.QBase.Error;


public class FileReadError extends QBaseError 
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

	@Override 
	public boolean equals(Object object) 
	{	
		if (!super.equals(object))
		{
			return false;
		}
		
		if (!(object instanceof FileReadError))
		{
			return false;
		}

		return true;
	}
}
