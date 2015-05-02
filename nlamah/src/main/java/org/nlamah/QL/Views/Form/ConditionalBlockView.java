package org.nlamah.QL.Views.Form;

import java.awt.Color;

import javax.swing.BoxLayout;

import org.nlamah.QL.Views.Form.Abstract.FormElementView;

@SuppressWarnings("serial")
public class ConditionalBlockView extends FormElementView 
{
	public ConditionalBlockView() 
	{
		super();
	}

	@Override
	public void layoutView() 
	{
		setBackground(Color.green);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
	}

	@Override
	public void initializeComponents() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void addComponentsToView() 
	{
		// TODO Auto-generated method stub

	}
}