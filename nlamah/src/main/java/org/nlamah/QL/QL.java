package org.nlamah.QL;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Builders.QLInterpreter;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.View.Controllers.FormRootViewController;

public class QL 
{
	public static void main(String[] args) 
	{
		try
		{
			String sourceCodePath = System.getProperty("user.dir") + "/target/classes/org/nlamah/QL/source.ql";

			if (args.length > 0)
			{
				sourceCodePath = System.getProperty("user.dir") + "/" + args[0];
			}

			QLInterpreter qlInterpreter = new QLInterpreter();

			Form form = qlInterpreter.interprete(sourceCodePath);	

			if (qlInterpreter.warnings().size() > 0)
			{
				SwingUtilities.invokeLater(new QBaseErrorViewController(qlInterpreter.warnings(), null));
			}

			SwingUtilities.invokeLater(new FormRootViewController(form));
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		} 
	}
}