package org.nlamah.QLS.Error;

import java.util.List;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;

@SuppressWarnings("serial")
public class QLSException extends QBaseException 
{
	public QLSException(List<QBaseWarning> warnings, List<QBaseError> errors) 
	{
		super(warnings, errors);
	}	
}
