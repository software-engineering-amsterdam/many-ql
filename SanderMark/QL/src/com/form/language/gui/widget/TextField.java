package com.form.language.gui.widget;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import com.form.language.ast.statement.Question;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class TextField extends JTextField {
	
	private static final long serialVersionUID = 1L;

	public TextField(Question question,QuestionComponent questionComponent, Context context) {
		setPreferredSize(new Dimension(100, 25));
		getDocument().addDocumentListener((DocumentListener) this);
		setVisible(true);
	}
	
	//TODO ADD HANDELER
	public void notifyListener(DocumentEvent e) {
		String s;
		try {
			s = e.getDocument().getText(0, e.getDocument().getLength());
			//If condition == true then show QUESTION
			//widgetListener.widgetValueChanged(getIdentifier(), new StringValue(s));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}
}
