package org.nlamah.QL.Views.Form;

import javax.swing.JPanel;

import org.nlamah.QL.Interfaces.ViewLoadingStrategy;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{
	protected FormElementViewController viewController;
	
	abstract public void initializeComponents();
	abstract public void addComponentsToView(); 
	
	public FormElementView(FormElementViewController viewController)
	{
		super();
		
		this.viewController = viewController;
		
		initializeComponents();
		addComponentsToView();
		layoutView();
	}
}
