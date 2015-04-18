package org.nlamah.QL.Error;

public class UnknownError extends QLError
{

	@Override
	public String description() 
	{
		return "There is an unknown error";
	}

}
