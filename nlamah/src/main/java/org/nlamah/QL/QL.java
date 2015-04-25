package org.nlamah.QL;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;

public class QL 
{
	public static void main(String[] args) 
	{
		String qlFileName = args.length > 0 ? args[0] : "source.ql";
		
		QLInterpreter qlInterpreter = new QLInterpreter();
		
		Form form = null;
		
		try
		{
			form = qlInterpreter.interprete(qlFileName);			
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		}
		
		if (qlInterpreter.warnings().size() > 0)
		{
			SwingUtilities.invokeLater(new QBaseErrorViewController(qlInterpreter.warnings(), null));
		}
		
		SwingUtilities.invokeLater(new FormRootViewController(form));	
	}
}
