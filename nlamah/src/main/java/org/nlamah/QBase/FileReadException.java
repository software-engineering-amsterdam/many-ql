package org.nlamah.QBase;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Error.QBaseWarning;

@SuppressWarnings("serial")
public class FileReadException extends QBaseException 
{
	public FileReadException(List<QBaseWarning> warnings, List<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}