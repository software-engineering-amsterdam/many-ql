package org.nlamah.QL.View.Form;

import javax.swing.BoxLayout;

import org.nlamah.QL.View.Controllers.ElseIfThenBlockViewController;
import org.nlamah.QL.View.Form.Abstract.FormElementView;

@SuppressWarnings("serial")
public class ElseIfThenBlockView extends FormElementView 
{	
	public ElseIfThenBlockView(ElseIfThenBlockViewController viewController) 
	{
		super();
		
		initializeComponents();
		addComponentsToView();
		layoutView();
	}

	@Override
	public void layoutView() 
	{
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
