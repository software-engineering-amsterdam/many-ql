package org.nlamah.QL.View.Widgets;

import java.awt.Dimension;

import javax.swing.JLabel;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
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

	public void setValue(ValueExpression value)
	{
		label.setText(value.toString());
	}
	
	@Override
	public void layoutView() 
	{
		label.setPreferredSize(new Dimension(UIConstants.widgetWidth(), UIConstants.maximumTextFieldHeight()));
		label.setMaximumSize(new Dimension(UIConstants.widgetWidth(), UIConstants.maximumTextFieldHeight()));
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