package org.nlamah.QL.View.Form.Widgets;

import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.nlamah.QL.View.Form.Abstract.QuestionWidget;

@SuppressWarnings("serial")
public class CheckboxWidget extends QuestionWidget 
{
	private JCheckBox checkbox;
	
	public CheckboxWidget(ItemListener itemListener) 
	{
		super();
		
		checkbox = new JCheckBox("Yes");
		checkbox.addItemListener(itemListener);

		add(checkbox);
	}

	public void setChecked(boolean checked) 
	{
		checkbox.setSelected(checked);
	}
}
