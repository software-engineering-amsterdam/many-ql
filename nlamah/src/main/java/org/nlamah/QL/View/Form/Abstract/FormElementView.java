package org.nlamah.QL.View.Form.Abstract;

import javax.swing.JPanel;

import org.nlamah.QL.Interfaces.ViewLoadingStrategy;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{	
	public FormElementView()
	{
		super();

		initializeComponents();
		addComponentsToView();
		layoutView();
	} 
}
