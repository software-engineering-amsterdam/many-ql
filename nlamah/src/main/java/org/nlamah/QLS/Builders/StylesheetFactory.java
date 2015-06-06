package org.nlamah.QLS.Builders;

import org.nlamah.QBase.FileReadException;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Error.QLSException;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

public class StylesheetFactory 
{	
	public Stylesheet stylesheet(String qlsSourceCodePath, Form form) throws FileReadException, QLSException
	{
		QLSInterpreter qlsInterpreter = new QLSInterpreter();
		
		return qlsInterpreter.interprete(qlsSourceCodePath, form);
	}
}
