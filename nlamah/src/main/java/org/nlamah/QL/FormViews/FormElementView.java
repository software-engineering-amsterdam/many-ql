package org.nlamah.QL.FormViews;

import javax.swing.JPanel;

import org.nlamah.QL.FormViewControllers.FormElementViewController;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{
	private FormElementViewController viewController;
	
	abstract public void initializeComponents();
	abstract public void addComponentsToView(); 
	
	public FormElementView(FormElementViewController viewController)
	{
		super();
		
		this.viewController = viewController;
		
		layoutView();
		initializeComponents();
		addComponentsToView();
	}
	
	public FormElementViewController viewController()
	{
		return this.viewController;
	}
}
