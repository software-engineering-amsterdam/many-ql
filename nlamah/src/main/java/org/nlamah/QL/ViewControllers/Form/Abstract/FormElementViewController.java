package org.nlamah.QL.ViewControllers.Form.Abstract;

import org.nlamah.QL.Helper.Helper;
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
	
//	public void setView(FormElementView view)
//	{
//		this.view = view;
//	}
//	
//	public FormElementViewController parentViewController() 
//	{
//		return parentViewController;
//	}
//
//	public void setParentViewController(FormElementViewController parentViewController) 
//	{
//		this.parentViewController = parentViewController;
//	}

	protected void notifyRelatedViewControllers()
	{
		if (Helper.arrayExistsAndHasElements(modelElement.relatedElements()))
		{
			for (FormElement relatedElement : modelElement.relatedElements())
			{
				relatedElement.viewController().modelStateChanged(modelElement);
			}
		}
	}
	
	
	abstract public int preferredViewHeight();
}
