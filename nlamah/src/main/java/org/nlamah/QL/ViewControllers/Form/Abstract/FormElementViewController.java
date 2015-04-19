package org.nlamah.QL.ViewControllers.Form.Abstract;

import org.nlamah.QL.Interfaces.FormElementListener;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Views.Form.FormElementView;

public abstract class FormElementViewController implements FormElementListener
{
	protected FormElement modelElement;
	protected FormElementView view;
	protected FormElementViewController parentViewController;
	
	public FormElementViewController(FormElement modelElement)
	{
		super();
		
		this.modelElement = modelElement;
	}
//TODO decide of the modelElemet should be reacheable
//	public FormElement modelElement()
//	{
//		return this.modelElement;
//	}
//	
	public FormElementView view()
	{
		return this.view;
		//TODO make this method not public.
	}
	
	abstract public int preferredViewHeight();
}