package org.nlamah.QL.Views.Form.Widgets;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QL.Views.Form.Abstract.QuestionWidget;

@SuppressWarnings("serial")
public class TextFieldWidget extends QuestionWidget 
{
	private JTextField textField;
	
	public TextFieldWidget(ActionListener actionListener)
	{
		super();
		
		textField = new JTextField();
		textField.addActionListener(actionListener);
		
		add(textField);
	}
	
	public void setText(String text)
	{
		textField.setText(text);
	}
}
