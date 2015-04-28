package org.nlamah.QL.ViewControllers.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.TextQuestionView;
import org.nlamah.QL.Views.Form.Widgets.TextFieldWidget;

public class TextQuestionViewController extends QuestionViewController implements ActionListener
{
	TextQuestionView questionView;
	
	public TextQuestionViewController(TextQuestion question) 
	{
		super(question);
		
		TextFieldWidget widget = new TextFieldWidget(this);
		
		questionView = new TextQuestionView(widget);
		questionView.fillInQuestionString(questionString());
		questionView.fillInTextField(question.insertedText().toString());
		
		view = questionView;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedTextString = ((JTextField) e.getSource()).getText();
		
		((TextQuestion) modelElement).setInsertedText(new TextLiteral(insertedTextString));
		
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
