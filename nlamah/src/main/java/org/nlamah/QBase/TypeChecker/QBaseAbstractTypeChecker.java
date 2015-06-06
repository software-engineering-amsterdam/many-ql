package org.nlamah.QBase.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Error.QBaseWarning;

public abstract class QBaseAbstractTypeChecker
{
	protected List<QBaseError> errors;
	protected List<QBaseWarning> warnings;

	public QBaseAbstractTypeChecker() 
	{
		errors = new ArrayList<QBaseError>();
		warnings = new ArrayList<QBaseWarning>();
	}

	public List<QBaseError>errors()
	{
		return this.errors;
	}
	
	public List<QBaseWarning> warnings()
	{
		return warnings;
	}
	
	protected void checkForErrors() throws QBaseException
	{
		if (errors.size() > 0)
		{
			throw new QBaseException(warnings, errors);
		}
	}
}