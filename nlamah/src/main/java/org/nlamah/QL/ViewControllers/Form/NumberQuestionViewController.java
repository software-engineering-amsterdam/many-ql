package org.nlamah.QL.ViewControllers.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.NumberQuestionView;

public class NumberQuestionViewController extends QuestionViewController implements ActionListener
{
	NumberQuestionView questionView;
	
	public NumberQuestionViewController(NumberQuestion question) 
	{
		super(question);
		
		questionView = new NumberQuestionView(this);
		
		questionView.fillInType(questionReturnType().name());
		questionView.fillInQuestionString(questionString());
		
		view = questionView;
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void viewNeedsUpdate() 
	{
		if(parentViewController != null)
		{
			parentViewController.viewNeedsUpdate();
		}
	}

	@Override
	public int preferredViewHeight() 
	{
		return view.getPreferredSize().height;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedNumberString = ((JTextField) e.getSource()).getText();
		
		((NumberQuestion) modelElement).setInsertedNumber(new NumberLiteral(insertedNumberString));
	}
}
