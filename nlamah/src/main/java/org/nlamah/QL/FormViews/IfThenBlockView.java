package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;

import org.nlamah.QL.FormViewControllers.IfThenBlockViewController;
import org.nlamah.QL.Helper.ArrayListHelper;

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
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		setPreferredSize(new Dimension(ArrayListHelper.contentWidth(), 100));
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
