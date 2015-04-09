package org.nlamah.QL.FormViews;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{
	abstract public void initializeComponents();
	abstract public void addComponentsToView(); 
}
