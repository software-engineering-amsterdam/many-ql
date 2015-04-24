package org.nlamah.QL.Model.Error;

import java.util.ArrayList;

import org.nlamah.QL.Model.Error.Abstract.QLError;

@SuppressWarnings("serial")
public class ParseTreeException extends QLException 
{	
	public ParseTreeException(ArrayList<QLError> errors)
	{
		super(errors);
	}
}
