package org.nlamah.QL.ViewControllers.Form;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.BooleanQuestionView;

public class BooleanQuestionViewController extends QuestionViewController implements ItemListener
{	
	private BooleanQuestionView questionView;
	
	public BooleanQuestionViewController(BooleanQuestion question)
	{
		super(question);
		
		questionView = new BooleanQuestionView(this);
		
		questionView.fillInType(questionReturnType().name());
		questionView.fillInQuestionString(questionString());
		questionView.fillInCheckbox(question.checked().primitiveValue());
		
		view = questionView;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		switch (e.getStateChange())
		{
			case ItemEvent.SELECTED: ((BooleanQuestion) modelElement).setChecked(new BooleanLiteral("yes"));
			break;
			
			case ItemEvent.DESELECTED: ((BooleanQuestion) modelElement).setChecked(new BooleanLiteral("yes"));
			break;
			
			default: break;
		}
		
		viewNeedsUpdate();
	}
		
	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void viewNeedsUpdate() 
	{
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
