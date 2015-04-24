package org.nlamah.QLS;

public class QLSInterpreter 
{
	public QLStylesheet interprete(String qlsFileName) throws QLSException
	{
		if (qlsFileName.equals(""))
		{
			throw new QLSException(null);
		}
		
		return null;
	}
}
