package org.nlamah.QL.View.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.View.Controllers.Abstract.QuestionViewController;
import org.nlamah.QL.View.Form.NumberQuestionView;
import org.nlamah.QL.View.Form.Widgets.NumberWidget;

public class NumberQuestionViewController extends QuestionViewController implements ActionListener
{
	NumberQuestionView questionView;
	
	public NumberQuestionViewController(NumberQuestion question) 
	{
		super(question);
		
		NumberWidget widget = new NumberWidget(this);
		widget.fillInNumberField(question.insertedNumber().toString());
		
		questionView = new NumberQuestionView(widget);
		
		questionView.fillInQuestionString(questionString());
		
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
