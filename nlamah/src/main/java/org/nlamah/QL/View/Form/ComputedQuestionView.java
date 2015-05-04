package org.nlamah.QL.View.Form;

import org.nlamah.QL.Interfaces.ViewLoadingStrategy;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Form.Widgets.ComputedValueWidget;

@SuppressWarnings("serial")
public class ComputedQuestionView extends QuestionView implements ViewLoadingStrategy
{			
	public ComputedQuestionView(ComputedValueWidget widget) 
	{
		super(widget);
	}
	
	public void fillInComputedValueLabel(String computedValueString)
	{
		((ComputedValueWidget) answerWidget).fillInComputedValue(computedValueString);
	}
	
	@Override
	public void addComponentsToView() 
	{
	}
	
	@Override
	public void initializeComponents() 
	{
	}

	@Override
	public void layoutView() 
	{	
	}
}
