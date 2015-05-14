package org.nlamah.QLS.Builders;

import org.nlamah.QL.Builders.QLViewFactory;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QL.View.Form.Abstract.FormElementView;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;

public class QLSViewFactory extends QLViewFactory 
{
	public FormElementView gatherViewForFormViewController(FormElementViewController formViewController, DefaultBlock styleBlock)
	{		
		formViewController.accept(this);

		return currentlyCreatedView;
	}
}
