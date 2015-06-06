package org.nlamah.QBase;

import org.nlamah.QL.Builders.QLFormFragmentiser;
import org.nlamah.QL.Builders.QLInterpreter;
import org.nlamah.QL.Error.QLException;
import org.nlamah.QL.Model.Form.Form;

public class FormFactory 
{
	private Language language;
	
	public FormFactory(Language language)
	{
		this.language = language;
	}
	
	public Form form(String qlSourceCodePath) throws FileReadException, QLException
	{
		Form form = null;
		
		switch (language)
		{
		case QL:
		{
			form = createBaseForm(qlSourceCodePath);
			
			break;
		}
		case QLS:
		{
			form = createBaseForm(qlSourceCodePath);
			
			form = new QLFormFragmentiser(form).form();
			
			break;
		}
		}
	
		return form;
	}
	
	private Form createBaseForm(String qlSourceCodePath) throws FileReadException, QLException
	{
		QLInterpreter qlInterpreter = new QLInterpreter();
		
		return qlInterpreter.interprete(qlSourceCodePath);
	}
}
