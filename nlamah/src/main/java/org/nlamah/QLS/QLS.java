package org.nlamah.QLS;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.FormFactory;
import org.nlamah.QBase.Language;
import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.StylesheetFactory;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.View.Controllers.RootFormViewControllerStyled;

public class QLS
{
	public static void main(String[] args) 
	{		
		try
		{	
			Form form = new FormFactory(Language.QLS).form(QBaseHelper.qlSourceCodePath(args));

			Stylesheet stylesheet = new StylesheetFactory().stylesheet(QBaseHelper.qlsSourceCodePath(args), form);

			SwingUtilities.invokeLater(new RootFormViewControllerStyled(form, stylesheet));
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		} 
	}
}