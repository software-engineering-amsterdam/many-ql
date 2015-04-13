package com.form.language.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class CheckBox extends Widget {
    private JCheckBox checkbox;

    public CheckBox(Question question, QuestionComponent questionComponent, Context context) {
	super(question,context);
	this.checkbox = new JCheckBox();

	this.checkbox.setName(question.getId());
	CheckBoxListener checkboxListener = new CheckBoxListener();
	this.checkbox.addItemListener((ItemListener) checkboxListener);
	setContextValue(new BoolValue());
    }

    public JCheckBox getCheckBox()
    {
	return checkbox;
    }

    private class CheckBoxListener implements ItemListener {
	public void itemStateChanged(ItemEvent e) {
	    setContextValue(new BoolValue(checkbox.isSelected()));
	    checkComputedQuestion();
	    checkDependencyVisibility();
	}
    }
}
