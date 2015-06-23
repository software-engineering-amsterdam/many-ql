package org.nlamah.QBase.Builders;

import org.nlamah.QBase.Constants.Language;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Builders.QLFormFragmentiser;
import org.nlamah.QL.Builders.QLInterpreter;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.TypeChecker.QLTypeChecker;

public class FormFactory 
{
	private boolean skipTypeChecking;
	
	private Language language;
	
	public FormFactory(Language language)
	{
		this.language = language;
	}
	
	public Form form(String qlSourceCodePath) throws QBaseException
	{
		Form form = null;
		
		switch (language)
		{
		case QL:
		{
			form = createBaseForm(qlSourceCodePath);
			
			typeCheck(form);
			
			break;
		}
		case QLS:
		{
			form = createBaseForm(qlSourceCodePath);
			
			typeCheck(form);
			
			form = new QLFormFragmentiser(form).form();
			
			break;
		}
		}
		
		return form;
	}
	
	private void typeCheck(Form form) throws QBaseException
	{
		if (!skipTypeChecking)
		{
			QLTypeChecker qlTypeChecker = new QLTypeChecker();
			
			qlTypeChecker.check(form);
		}
	}
	
	public void skipTypeChecking()
	{
		skipTypeChecking = true;
	}
	
	private Form createBaseForm(String qlSourceCodePath) throws QBaseException
	{
		QLInterpreter qlInterpreter = new QLInterpreter();
		
		if (skipTypeChecking)
		{
			qlInterpreter.skipTypeChecking();
		}
		
		return qlInterpreter.interprete(qlSourceCodePath);
	}
}
