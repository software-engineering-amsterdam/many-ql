package org.nlamah.QL.FormViewControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.FormModel.InputQuestion;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.BooleanQuestionView;
import org.nlamah.QL.Helper.Helper;

public class BooleanQuestionViewController extends QuestionViewController implements ItemListener
{	
	private BooleanQuestionView questionView;
	
	public BooleanQuestionViewController(InputQuestion question)
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
			case ItemEvent.SELECTED: ((InputQuestion)modelElement()).setChecked(true);
			break;
			
			case ItemEvent.DESELECTED: ((InputQuestion)modelElement()).setChecked(false);
			break;
			
			default: break;
		}
		
		notifyRelatedViewControllers();
		viewNeedsUpdate();
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
	public int preferredViewHeight() 
	{
		return view().getPreferredSize().height;
	}

	@Override
	public void viewNeedsUpdate() 
	{
		if(parentViewController() != null)
		{
			parentViewController().viewNeedsUpdate();
		}
	}
}
