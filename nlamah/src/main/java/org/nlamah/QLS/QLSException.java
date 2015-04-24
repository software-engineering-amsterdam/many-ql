package org.nlamah.QLS;

import java.util.ArrayList;

import org.nlamah.QL.Model.Error.QLException;
import org.nlamah.QL.Model.Error.Abstract.QLError;

@SuppressWarnings("serial")
public class QLSException extends QLException 
{

	public QLSException(ArrayList<QLError> errors) 
	{
		super(errors);
	}	

}
