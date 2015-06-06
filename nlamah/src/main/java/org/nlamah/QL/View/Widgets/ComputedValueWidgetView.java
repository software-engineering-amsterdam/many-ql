package org.nlamah.QL.View.Widgets;

import javax.swing.JLabel;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class ComputedValueWidgetView extends WidgetView 
{
	private JLabel label;

	public ComputedValueWidgetView() 
	{
		super(QBaseQuestionType.TEXT);

		initializeComponents();
		addComponentsToView();
		layoutView();
	}

	@Override
	public void layoutView() 
	{
	}

	@Override
	public void initializeComponents() 
	{
		label = new JLabel();
	}

	@Override
	public void addComponentsToView() 
	{
		add(label);
	}
}