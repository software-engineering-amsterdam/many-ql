package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;

import org.nlamah.QL.FormViewControllers.IfThenBlockViewController;
import org.nlamah.QL.Helper.Helper;

@SuppressWarnings("serial")
public class IfThenBlockView extends FormElementView 
{	
	public IfThenBlockView(IfThenBlockViewController viewController)
	{
		super(viewController);
	}

	@Override
	public void layoutView() 
	{
		setBackground(Color.red);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setPreferredSize(new Dimension(Helper.contentWidth(), Integer.MAX_VALUE));
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
