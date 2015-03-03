package com.form.language.gui.widget;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.RuntimeMemory;

public class TextField extends JTextField implements Widget {
	
	private static final long serialVersionUID = 1L;
	//private WidgetListener widgetListener;
	private Expression showCondition;
	private RuntimeMemory rm;
	private Question question;

	public TextField(Question question,Expression showCondition, RuntimeMemory rm) {
		this.showCondition = showCondition;
		setPreferredSize(new Dimension(100, 25));
		getDocument().addDocumentListener((DocumentListener) this);
		setVisible(true);
	}
	
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


	@Override
	public <T> T getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdentifier(String identifier) {
		// TODO Auto-generated method stub
		
	}

}
