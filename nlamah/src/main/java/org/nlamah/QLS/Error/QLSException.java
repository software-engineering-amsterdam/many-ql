package org.nlamah.QLS.Error;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;

@SuppressWarnings("serial")
public class QLSException extends QBaseException 
{
	public QLSException(List<QBaseError> errors) 
	{
		super(null, errors);
	}	
}