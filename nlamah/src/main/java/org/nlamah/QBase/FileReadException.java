package org.nlamah.QBase;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FileReadException extends QBaseException 
{
	public FileReadException(ArrayList<QBaseWarning> warnings, ArrayList<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}
