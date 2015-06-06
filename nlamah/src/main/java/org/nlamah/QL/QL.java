package org.nlamah.QL;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.FormFactory;
import org.nlamah.QBase.Language;
import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.View.Controllers.FormRootViewController;

public class QL 
{
	public static void main(String[] args) 
	{
		try
		{
			Form form = new FormFactory(Language.QL).form(QBaseHelper.qlSourceCodePath(args), true);

			SwingUtilities.invokeLater(new FormRootViewController(form));
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		} 
	}
}