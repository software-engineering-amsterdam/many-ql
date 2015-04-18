package org.nlamah.QL.Views.Form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.ViewControllers.Form.ConditionalBlockViewController;

@SuppressWarnings("serial")
public class ConditionalBlockView extends FormElementView 
{
	public ConditionalBlockView(ConditionalBlockViewController viewController) 
	{
		super(viewController);
	}

	@Override
	public void layoutView() 
	{
		setBackground(Color.green);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		setPreferredSize(new Dimension(Helper.contentWidth(), 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize()); 
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
