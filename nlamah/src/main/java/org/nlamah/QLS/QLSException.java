package org.nlamah.QLS;

import java.util.ArrayList;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;

@SuppressWarnings("serial")
public class QLSException extends QBaseException 
{
	public QLSException(ArrayList<QBaseError> errors) 
	{
		super(errors);
	}	

}
