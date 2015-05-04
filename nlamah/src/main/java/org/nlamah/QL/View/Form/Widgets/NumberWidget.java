package org.nlamah.QL.View.Form.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.View.Form.Abstract.QuestionWidget;

@SuppressWarnings("serial")
public class NumberWidget extends QuestionWidget 
{
	private JTextField textField;

	public NumberWidget(ActionListener actionListener)
	{
		textField = new JFormattedTextField(NumberFormat.getNumberInstance());
		textField.addActionListener(actionListener);
		
		textField.setPreferredSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		textField.setMaximumSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		
		add(textField);
	}
	
	public void fillInNumberField(String number)
	{
		textField.setText(number);
	}
}
