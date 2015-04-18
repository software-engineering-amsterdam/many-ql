package org.nlamah.QL.Error;

public class InterconnectionError extends QLError 
{

	@Override
	public String description() 
	{
		return "There is a mistake in interconnecting the nodes";
	}

}
