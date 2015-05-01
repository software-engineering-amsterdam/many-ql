package org.nlamah.QLS;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QL.QLInterpreter;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Model.QLStylesheet;

public class QLS 
{
	public static void main(String[] args) 
	{
		String qlFileName = args.length > 0 ? args[0] : "source.ql";
		String qlsFileName = args.length > 1 ? args[1] : "stylesheet.qls";
		
		QLInterpreter qlInterpreter = new QLInterpreter();
		
		Form form = null;
		QLStylesheet stylesheet = null;
		RootFormViewControllerStyled rootViewController = null;
		
		try
		{
		//	form = qlInterpreter.interprete(qlFileName);
			
			QLSInterpreter qlsInterpreter = new QLSInterpreter();
			
			stylesheet = qlsInterpreter.interprete("QLS/" + qlsFileName, form);
			
			QLStylesheetAdapter adapter = new QLStylesheetAdapter();
			adapter.adapt(form, stylesheet);
			
			SwingUtilities.invokeLater(rootViewController);
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		}
	}
}
