package com.form.language.gui.widget;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.IntValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class IntegerTextField extends Widget {
  
	private JTextField textfield;
	
	public IntegerTextField(Question question, QuestionComponent questionComponent, Context context) {
		super(question,context);
		this.textfield = new JTextField();
		
		this.textfield.setName(question.getId());		
		this.textfield.setMaximumSize(new Dimension(200, 20));
		TextFieldListener textfieldListener = new TextFieldListener();
		this.textfield.getDocument().addDocumentListener(textfieldListener);
	}
	
	public JTextField getTextField()
	{
		return textfield;
	}

	private class TextFieldListener implements DocumentListener {
		public void actionPerformed(DocumentEvent e) {
			//JOptionPane.showMessageDialog(textfield, "Eggs are not supposed to be green.");
			Integer value = tryParse(textfield.getText(),textfield);
			if(value != null)
			{
			setContextValue(new IntValue(value));
			}
			checkDependencyVisibility();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			actionPerformed(e);			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			actionPerformed(e);			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			actionPerformed(e);			
		}
	}
	
	private static Integer tryParse(String text,Component textfield) {
		  try {
		    return new Integer(text);
		  } catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(textfield, "Invalid value");
		    return null;
		  }
		}
}
