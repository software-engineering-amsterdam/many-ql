package org.nlamah.QL.View.Widgets;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class CheckboxWidgetView extends WidgetView implements ItemListener
{
	private JCheckBox checkbox;

	public CheckboxWidgetView() 
	{
		super(QBaseQuestionType.BOOLEAN);

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
		BooleanLiteral defaultValue = (BooleanLiteral)UIConstants.defaultValueForQuestionType(QBaseQuestionType.BOOLEAN);
		
		checkbox = new JCheckBox("Yes", defaultValue.primitiveValue());
		checkbox.addItemListener(this);
	}

	@Override
	public void addComponentsToView() 
	{
		add(checkbox);	
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		switch (e.getStateChange())
		{
		case ItemEvent.SELECTED: widgetViewDelegate.valueChanged(new BooleanLiteral(true));
		break;

		case ItemEvent.DESELECTED: widgetViewDelegate.valueChanged(new BooleanLiteral(false));
		break;

		default: break;
		}
	}	
}