package org.nlamah.Main;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QL.QLInterpreter;
import org.nlamah.QL.QLTypeChecker;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QLS.QLSInterpreter;
import org.nlamah.QLS.QLSTypeChecker;
import org.nlamah.QLS.QLStylesheet;

public class Main 
{
	public static void main(String[] args) 
	{
		String qlFileName = args.length > 0 ? args[0] : "source.ql";
		String qlsFileName = args.length > 1 ? args[1] : "stylesheet.qls";
		
		QLInterpreter qlInterpreter = new QLInterpreter();
		
		Form form = null;
		QLStylesheet stylesheet = null;
		
		try
		{
			form = qlInterpreter.interprete(qlFileName);
			
			QLTypeChecker typeChecker = new QLTypeChecker();
			typeChecker.check(form);
			
			QLSInterpreter qlsInterpreter = new QLSInterpreter();
			stylesheet = qlsInterpreter.interprete(qlsFileName);
			
			QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();
			qlsTypeChecker.check(form, stylesheet);
			
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.errors(), null));
		}

		SwingUtilities.invokeLater(new FormRootViewController(form));
	}
}
