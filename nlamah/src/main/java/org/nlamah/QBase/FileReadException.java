package org.nlamah.QBase;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;

@SuppressWarnings("serial")
public class FileReadException extends QBaseException 
{
	public FileReadException(List<QBaseError> errors) 
	{
		super(errors);
	}
}