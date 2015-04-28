package org.nlamah.QL.Views.Form;

import org.nlamah.QL.Views.Form.Abstract.QuestionView;
import org.nlamah.QL.Views.Form.Abstract.QuestionWidget;
import org.nlamah.QL.Views.Form.Widgets.TextFieldWidget;

@SuppressWarnings("serial")
public class TextQuestionView extends QuestionView 
{
	public TextQuestionView(QuestionWidget widget) 
	{
		super(widget);
	}
	
	public void fillInTextField(String text)
	{
		((TextFieldWidget) answerWidget).setText(text);
	}
	
	@Override
	public void layoutView() 
	{
	}

	@Override
	public void initializeComponents() 
	{
	}

	@Override
	public void addComponentsToView() 
	{
	}
}
