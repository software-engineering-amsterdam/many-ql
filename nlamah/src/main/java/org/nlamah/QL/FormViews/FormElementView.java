package org.nlamah.QL.FormViews;

import javax.swing.JPanel;

import org.nlamah.QL.FormViewControllers.FormElementListener;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{
	protected FormElementListener formElementViewListener;
	
	abstract public void initializeComponents();
	abstract public void addComponentsToView(); 
	
	public void setFormElementListener(FormElementListener formElementViewListener)
	{
		this.formElementViewListener = formElementViewListener;
	}
}
