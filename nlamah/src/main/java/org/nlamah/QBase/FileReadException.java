package org.nlamah.QBase;

import java.util.List;

@SuppressWarnings("serial")
public class FileReadException extends QBaseException 
{
	public FileReadException(List<QBaseWarning> warnings, List<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}
