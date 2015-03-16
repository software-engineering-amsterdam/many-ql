package com.form.language.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import com.form.language.ast.statement.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class CheckBox extends Widget {
	private static final long serialVersionUID = 1L;
	private JCheckBox checkbox;

	public CheckBox(Question question, QuestionComponent questionComponent, Context context) {
		super(question,context);
		this.checkbox = new JCheckBox();
		
		CheckBoxListener checkboxListener = new CheckBoxListener();
		this.checkbox.addItemListener((ItemListener) checkboxListener);
	}
	
	// TODO: quick fix can be done better
	public JCheckBox getCheckBox()
	{
		return this.checkbox;
	}

	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			setContextBoolean(new BoolValue(CheckBox.this.checkbox.isSelected()));
			checkDependencyVisibility();
		}
	}
}
