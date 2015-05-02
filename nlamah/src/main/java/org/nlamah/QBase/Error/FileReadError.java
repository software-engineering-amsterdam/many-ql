package org.nlamah.QBase.Error;

import org.nlamah.QBase.QBaseError;

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
		 if (!(object instanceof FileReadError))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}