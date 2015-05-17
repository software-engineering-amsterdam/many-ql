package org.nlamah.QL.View.Form;

import javax.swing.BoxLayout;

import org.nlamah.QL.View.Form.Abstract.FormElementView;

@SuppressWarnings("serial")
public class IfThenBlockView extends FormElementView 
{	
	public IfThenBlockView()
	{
		super(null);
		
		initializeComponents();
		addComponentsToView();
		layoutView();
	}

	@Override
	public void layoutView() 
	{
	}

	@Override
	public void initializeComponents() 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@Override
	public void addComponentsToView() 
	{
	}
}
