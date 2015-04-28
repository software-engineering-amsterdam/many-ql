package org.nlamah.QL.Views.Form;

import javax.swing.JTextField;

import org.nlamah.QL.Views.Form.Abstract.QuestionView;
import org.nlamah.QL.Views.Form.Abstract.QuestionWidget;
import org.nlamah.QL.Views.Form.Widgets.NumberWidget;

@SuppressWarnings("serial")
public class NumberQuestionView extends QuestionView
{	
	JTextField textField;
	
	public NumberQuestionView(QuestionWidget widget) 
	{
		super(widget);
	}

	public void fillInNumberField(String number)
	{
		((NumberWidget) answerWidget).fillInNumberField(number);
	}
	
	@Override
	public void layoutView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponentsToView() {
		// TODO Auto-generated method stub
		
	}
}
