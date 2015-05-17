package org.nlamah.QBase;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;

@SuppressWarnings("serial")
public class QBaseException extends Exception 
{
	private List<QBaseWarning> warnings;
	private List<QBaseError> errors;

	public QBaseException(List<QBaseWarning> warnings, List<QBaseError> errors)
	{
		this.warnings = warnings;
		this.errors = errors;
	}

	public List<QBaseWarning> warnings()
	{
		return warnings;
	}

	public List<QBaseError> errors()
	{
		return errors;
	}
}
