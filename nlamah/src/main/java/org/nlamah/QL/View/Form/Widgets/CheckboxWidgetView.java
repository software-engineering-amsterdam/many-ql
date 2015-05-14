package org.nlamah.QL.View.Form.Widgets;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class CheckboxWidgetView extends WidgetView implements ItemListener
{
	private JCheckBox checkbox;
	
	public CheckboxWidgetView() 
	{
		super(QBaseQuestionType.BOOLEAN);
		
		checkbox = new JCheckBox("Yes");
		checkbox.addItemListener(this);

		add(checkbox);
	}
	
	@Override
	public ValueExpression value() 
	{
		return new BooleanLiteral(checkbox.isSelected());
	}

	
	@Override
	public void setValue(ValueExpression value) 
	{
		if (value == null)
		{
			return;
		}
		
		this.value = value;
		
		assert(value instanceof BooleanLiteral);
		
		checkbox.setSelected(((BooleanLiteral) value).primitiveValue());
	}

	@Override
	public void layoutView() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeComponents() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponentsToView() 
	{
		// TODO Auto-generated method stub
		
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
