package org.nlamah.QLS;

import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Model.QLStylesheet;

public class QLSTypeChecker 
{
	public QLSTypeChecker()
	{
		super();
	}
	
	public void check(Form form, QLStylesheet stylesheet) throws QLSException
	{
		if (form == null)
		{
			throw new QLSException(null, null);
		}
	}
}
