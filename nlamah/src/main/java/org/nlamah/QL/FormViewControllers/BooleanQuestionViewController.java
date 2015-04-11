package org.nlamah.QL.FormViewControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.FormModel.BooleanQuestion;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.BooleanQuestionView;
import org.nlamah.QL.Helper.Helper;

public class BooleanQuestionViewController extends QuestionViewController implements ItemListener
{	
	private BooleanQuestionView questionView;
	
	public BooleanQuestionViewController(BooleanQuestion question)
	{
		super(question);
		
		questionView = new BooleanQuestionView(this);
		
		questionView.fillInType(questionType());
		questionView.fillInQuestionString(questionString());
		
		setView(questionView);
	}

	private String questionType()
	{
		return ((Question) modelElement()).type();
	}
	
	private String questionString()
	{
		return ((Question) modelElement()).questionString();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		switch (e.getStateChange())
		{
			case ItemEvent.SELECTED: ((BooleanQuestion)modelElement()).setChecked(true);
			break;
			case ItemEvent.DESELECTED: ((BooleanQuestion)modelElement()).setChecked(false);
			break;
			default: break;
		}
		
		notifyRelatedViewControllers();
	}
	
	private void notifyRelatedViewControllers()
	{
		if (Helper.arrayExistsAndHasElements(modelElement().relatedElements()))
		{
			for (FormElement relatedElement : modelElement().relatedElements())
			{
				relatedElement.viewController().modelStateChanged(modelElement());
			}
		}
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	int preferredViewHeight() 
	{
		return view().getPreferredSize().height;
	}
}
