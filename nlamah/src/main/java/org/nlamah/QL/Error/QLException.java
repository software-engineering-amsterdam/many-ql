package org.nlamah.QL.Error;

import java.util.List;

import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QBase.Error.QBaseError;

@SuppressWarnings("serial")
public class QLException extends QBaseException 
{
	public QLException(List<QBaseWarning> warnings, List<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}
