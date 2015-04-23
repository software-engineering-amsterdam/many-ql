package org.nlamah.QL.ViewControllers.Form.Abstract;

import org.nlamah.QL.Interfaces.Showable;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QL.Views.Abstract.FormElementView;

public abstract class FormElementViewController implements Showable
{
	protected FormElement modelElement;
	protected FormElementView view;
	
	protected FormRootViewController rootViewController;
	
	public FormElementViewController(FormElement modelElement)
	{
		super();
		
		this.modelElement = modelElement;
	}

	public void setRootViewController(FormRootViewController rootViewController) 
	{
		this.rootViewController = rootViewController;
	}
	
	public FormElementView view()
	{
		return this.view;
	}
	
	abstract public int neededViewHeight();
}