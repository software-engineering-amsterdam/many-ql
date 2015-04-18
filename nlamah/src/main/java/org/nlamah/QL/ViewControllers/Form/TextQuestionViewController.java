package org.nlamah.QL.ViewControllers.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.TextQuestionView;

public class TextQuestionViewController extends QuestionViewController implements ActionListener
{
	TextQuestionView questionView;
	
	public TextQuestionViewController(TextQuestion question) 
	{
		super(question);
		
		questionView = new TextQuestionView(this);
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
		// TODO Auto-generated method stub
	}

	@Override
	public int preferredViewHeight() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedTextString = ((JTextField) e.getSource()).getText();
		
		((TextQuestion) modelElement).setInsertedText(new TextLiteral(insertedTextString));
			
		notifyRelatedViewControllers();
	}
}
