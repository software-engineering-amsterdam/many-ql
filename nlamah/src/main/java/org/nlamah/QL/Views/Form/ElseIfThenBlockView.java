package org.nlamah.QL.Views.Form;

import java.awt.Color;

import javax.swing.BoxLayout;

import org.nlamah.QL.ViewControllers.Form.ElseIfThenBlockViewController;
import org.nlamah.QL.Views.Abstract.FormElementView;

@SuppressWarnings("serial")
public class ElseIfThenBlockView extends FormElementView 
{	
	public ElseIfThenBlockView(ElseIfThenBlockViewController viewController) 
	{
		super(viewController);
	}

	@Override
	public void layoutView() 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBackground(Color.blue);

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
