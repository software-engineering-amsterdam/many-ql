package org.nlamah.QL.View.Form.Abstract;

import javax.swing.JPanel;

import org.nlamah.QL.Interfaces.ViewLoadingStrategy;
import org.nlamah.QL.Model.Form.Abstract.FormElement;

@SuppressWarnings("serial")
public abstract class FormElementView extends JPanel implements ViewLoadingStrategy
{	
	protected FormElement modelElement;

	public FormElementView(FormElement modelElement)
	{
		this.modelElement = modelElement;
	} 
}