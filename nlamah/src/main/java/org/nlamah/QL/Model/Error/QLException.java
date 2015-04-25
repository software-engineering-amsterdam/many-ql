package org.nlamah.QL.Model.Error;

import java.util.ArrayList;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;

@SuppressWarnings("serial")
public class QLException extends QBaseException 
{
	public QLException(ArrayList<QBaseWarning> warnings, ArrayList<QBaseError> errors) 
	{
		super(warnings, errors);
	}
}
