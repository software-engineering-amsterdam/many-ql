package org.nlamah.QL.View.Form.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.View.Form.Abstract.QuestionWidget;

@SuppressWarnings("serial")
public class TextFieldWidget extends QuestionWidget 
{
	private JTextField textField;
	
	public TextFieldWidget(ActionListener actionListener)
	{
		super();
		
		textField = new JTextField();
		textField.addActionListener(actionListener);
		
		textField.setPreferredSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		textField.setMaximumSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		
		add(textField);
	}
	
	public void setText(String text)
	{
		textField.setText(text);
	}
}
