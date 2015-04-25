package org.nlamah.QLS;

import java.util.ArrayList;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;

@SuppressWarnings("serial")
public class QLSException extends QBaseException 
{
	public QLSException(ArrayList<QBaseWarning> warnings, ArrayList<QBaseError> errors) 
	{
		super(warnings, errors);
	}	

}
