package org.nlamah.QL.Views.Form;

import org.nlamah.QL.Views.Form.Abstract.QuestionView;
import org.nlamah.QL.Views.Form.Abstract.QuestionWidget;

@SuppressWarnings("serial")
public class BooleanQuestionView extends QuestionView 
{		
	public BooleanQuestionView(QuestionWidget widget) 
	{
		super(widget);
	}

	public void fillInCheckbox(boolean isChecked)
	{
		//checkBox.setSelected(isChecked);
	}

	@Override
	public void initializeComponents()
	{
	}

	@Override
	public void addComponentsToView()
	{	
	}

	@Override
	public void layoutView() 
	{	
	}
}
