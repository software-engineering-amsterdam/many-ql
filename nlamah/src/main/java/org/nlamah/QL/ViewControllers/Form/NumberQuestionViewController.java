package org.nlamah.QL.ViewControllers.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Form.NumberQuestion;
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
		questionView.fillInNumberField(question.insertedNumber().toString());
		
		view = questionView;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedNumberString = ((JTextField) e.getSource()).getText();
		
		((NumberQuestion) modelElement).setInsertedNumber(new NumberLiteral(insertedNumberString));
		
		rootViewController.modelStateChanged();
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
	
	@Override
	public int neededViewHeight() 
	{
		return view.getPreferredSize().height;
	}
}
