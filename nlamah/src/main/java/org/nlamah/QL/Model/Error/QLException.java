package org.nlamah.QL.Model.Error;

import java.util.ArrayList;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;

@SuppressWarnings("serial")
public class QLException extends QBaseException 
{
	public QLException(ArrayList<QBaseError> errors) 
	{
		super(errors);
	}
}
