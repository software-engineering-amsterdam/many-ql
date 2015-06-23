package org.nlamah.QBase.Error;

import java.util.List;

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

	public QBaseException(List<QBaseError> errors)
	{
		this(null, errors);
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