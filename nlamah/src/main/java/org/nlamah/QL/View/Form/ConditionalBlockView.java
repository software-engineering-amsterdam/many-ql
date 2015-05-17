package org.nlamah.QL.View.Form;

import java.awt.Color;

import javax.swing.BoxLayout;

import org.nlamah.QL.View.Form.Abstract.FormElementView;

@SuppressWarnings("serial")
public class ConditionalBlockView extends FormElementView 
{
	public ConditionalBlockView() 
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
		setBackground(Color.green);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
	}

	@Override
	public void addComponentsToView() 
	{
	}
}
