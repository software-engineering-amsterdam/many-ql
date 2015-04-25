package org.nlamah.QBase;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class QBaseException extends Exception 
{
	private ArrayList<QBaseError> errors;
	
	public QBaseException(ArrayList<QBaseError> errors)
	{
		this.errors = errors;
	}
	
	public ArrayList<QBaseError> errors()
	{
		return this.errors;
	}
}
