package org.nlamah.QL.Error;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Error.QBaseWarning;

@SuppressWarnings("serial")
public class QLException extends QBaseException 
{
	public QLException(List<QBaseWarning> warnings, List<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}