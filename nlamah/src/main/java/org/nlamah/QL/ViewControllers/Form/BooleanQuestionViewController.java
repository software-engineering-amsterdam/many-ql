package org.nlamah.QL.ViewControllers.Form;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.BooleanQuestionView;
import org.nlamah.QL.Views.Form.Widgets.CheckboxWidget;

public class BooleanQuestionViewController extends QuestionViewController implements ItemListener
{	
	private BooleanQuestionView questionView;
	
	public BooleanQuestionViewController(BooleanQuestion question)
	{
		super(question);
		
		CheckboxWidget widget = new CheckboxWidget(this);
		
		questionView = new BooleanQuestionView(widget);
		
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
			
			case ItemEvent.DESELECTED: ((BooleanQuestion) modelElement).setChecked(new BooleanLiteral("no"));
			break;
			
			default: break;
		}
		
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
