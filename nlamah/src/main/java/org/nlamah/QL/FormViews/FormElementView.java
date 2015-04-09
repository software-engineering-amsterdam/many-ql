package org.nlamah.QL.FormViews;

import javax.swing.JPanel;

import org.nlamah.QL.FormViewControllers.FormElementViewListener;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{
	protected FormElementViewListener formElementViewListener;
	
	abstract public void initializeComponents();
	abstract public void addComponentsToView(); 
	
	public void setFormElementViewListener(FormElementViewListener formElementViewListener)
	{
		this.formElementViewListener = formElementViewListener;
	}
}
