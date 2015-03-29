package com.form.language.gui.widget;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.StringValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class TextField extends Widget { 
    private JTextField textfield;

    public TextField(Question question, QuestionComponent questionComponent, Context context) {
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
	    setContextValue(new StringValue(textfield.getText()));
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
}
