package org.nlamah.QL.Model.Error;

import java.util.ArrayList;

import org.nlamah.QL.Model.Error.Abstract.QLError;

@SuppressWarnings("serial")
public class QLException extends Exception 
{
	private ArrayList<QLError> errors;
	
	public QLException(ArrayList<QLError> errors)
	{
		this.errors = errors;
	}
	
	public ArrayList<QLError> errors()
	{
		return this.errors;
	}
}
