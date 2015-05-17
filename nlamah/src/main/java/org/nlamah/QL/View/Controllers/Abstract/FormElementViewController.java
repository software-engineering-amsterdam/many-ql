package org.nlamah.QL.View.Controllers.Abstract;

import org.nlamah.QL.Interfaces.QLShowable;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.View.Controllers.FormRootViewController;
import org.nlamah.QL.View.Form.Abstract.FormElementView;

public abstract class FormElementViewController implements QLShowable
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

	abstract public int evaluateViewHeight();
}