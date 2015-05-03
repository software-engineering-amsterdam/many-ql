package org.nlamah.QBase;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.Error.QBaseError;

public abstract class QBaseAbstractTypeChecker
{
	protected List<QBaseError> errors;
	
	public QBaseAbstractTypeChecker() 
	{
		errors = new ArrayList<QBaseError>();
	}
	
	public List<QBaseError>errors()
	{
		return this.errors;
	}
}
