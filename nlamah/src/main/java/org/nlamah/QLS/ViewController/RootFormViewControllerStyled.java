package org.nlamah.QLS.ViewController;

import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

public class RootFormViewControllerStyled extends FormRootViewController
{
	public RootFormViewControllerStyled(Form form, Stylesheet stylesheet) 
	{
		super(form);
	}

	@Override
	public void run() 
	{
		showForm();
	}
}
