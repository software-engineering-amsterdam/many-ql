package org.nlamah.QLS;

import javax.swing.SwingUtilities;

import org.nlamah.QBase.QBaseErrorViewController;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QL.Builders.QLFormFragmentiser;
import org.nlamah.QL.Builders.QLInterpreter;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.QLSInterpreter;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.View.Controllers.RootFormViewControllerStyled;

public class QLS 
{
	public static void main(String[] args) 
	{
		try
		{	
			String qlSourceCodePath = getQLSourceCodePath(args);
			String qlsSourceCodePath = getQLSSourceCodePath(args);
			
			QLInterpreter qlInterpreter = new QLInterpreter();
			
			Form form = null;
			Stylesheet stylesheet = null;
	
			form = qlInterpreter.interprete(qlSourceCodePath);
			
			form = new QLFormFragmentiser(form).form();
			
			QLSInterpreter qlsInterpreter = new QLSInterpreter();
			
			stylesheet = qlsInterpreter.interprete(qlsSourceCodePath, form);
			
			SwingUtilities.invokeLater(new RootFormViewControllerStyled(form, stylesheet));
		}
		catch(QBaseException exception)
		{	
			SwingUtilities.invokeLater(new QBaseErrorViewController(exception.warnings(), exception.errors()));
		} 
	}
	
	private static String getQLSourceCodePath(String[] args)
	{
		String qlSourceCodePath = System.getProperty("user.dir") + "/target/classes/org/nlamah/QL/source.ql";
		
		if (args.length > 0)
		{
			qlSourceCodePath = System.getProperty("user.dir") + "/" + args[0];
		}
		
		return qlSourceCodePath;
	}
	
	private static String getQLSSourceCodePath(String[] args)
	{
		String qlsSourceCodePath = System.getProperty("user.dir") + "/target/classes/org/nlamah/QLS/stylesheet.qls";
		
		if (args.length > 1)
		{
			qlsSourceCodePath = System.getProperty("user.dir") + "/" + args[1];
		}
		
		return qlsSourceCodePath;
	}
}
