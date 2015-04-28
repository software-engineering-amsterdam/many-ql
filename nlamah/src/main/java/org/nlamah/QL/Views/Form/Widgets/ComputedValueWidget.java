package org.nlamah.QL.Views.Form.Widgets;

import javax.swing.JLabel;

import org.nlamah.QL.Views.Form.Abstract.QuestionWidget;

@SuppressWarnings("serial")
public class ComputedValueWidget extends QuestionWidget 
{
	private JLabel label;
	
	public ComputedValueWidget() 
	{
		super();
		
		label = new JLabel();

		add(label);
	}
	
	public void fillInComputedValue(String value)
	{
		label.setText(value);
	}
}

