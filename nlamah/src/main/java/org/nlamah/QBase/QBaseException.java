package org.nlamah.QBase;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class QBaseException extends Exception 
{
	private ArrayList<QBaseWarning> warnings;
	private ArrayList<QBaseError> errors;

	public QBaseException(ArrayList<QBaseWarning> warnings, ArrayList<QBaseError> errors)
	{
		this.warnings = warnings;
		this.errors = errors;
	}
	
	public ArrayList<QBaseWarning> warnings()
	{
		return warnings;
	}
	
	public ArrayList<QBaseError> errors()
	{
		return errors;
	}
}
