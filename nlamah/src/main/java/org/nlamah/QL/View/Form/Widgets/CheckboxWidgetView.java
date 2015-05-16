package org.nlamah.QL.View.Form.Widgets;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.nlamah.QBase.QBaseQuestionType;
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
		checkbox = new JCheckBox("Yes");
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
			case ItemEvent.SELECTED: widgetViewDelegate.valueChanged(new BooleanLiteral("yes"));
			break;
			
			case ItemEvent.DESELECTED: widgetViewDelegate.valueChanged(new BooleanLiteral("no"));
			break;
			
			default: break;
		}
	}	
}
