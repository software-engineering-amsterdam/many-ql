package org.nlamah.QL.Model.Error;

import java.util.List;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;

@SuppressWarnings("serial")
public class QLException extends QBaseException 
{
	public QLException(List<QBaseWarning> warnings, List<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}
