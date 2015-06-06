package org.nlamah.QL;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.Builders.FormFactory;
import org.nlamah.QBase.Constants.Language;
import org.nlamah.QBase.Error.QBaseErrorViewController;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Tools.SourceCodeTools;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.View.Controllers.FormRootViewController;

public class QL 
{
	public static void main(String[] args) 
	{
		try
		{
			Form form = new FormFactory(Language.QL).form(SourceCodeTools.qlSourceCodePath(args));

			SwingUtilities.invokeLater(new FormRootViewController(form));
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		} 
	}
}