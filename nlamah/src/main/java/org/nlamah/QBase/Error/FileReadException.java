package org.nlamah.QBase.Error;

import java.util.List;

@SuppressWarnings("serial")
public class FileReadException extends QBaseException 
{
	public FileReadException(List<QBaseError> errors) 
	{
		super(errors);
	}
}