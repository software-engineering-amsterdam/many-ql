package com.form.language.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.memory.RuntimeMemory;

public class CheckBox extends JCheckBox implements Widget {
	private static final long serialVersionUID = 1L;
	//private WidgetListener widgetListener;
	private Expression showCondition;
	private RuntimeMemory rm;
	private Question question;
	
	public CheckBox(Question question, Expression showCondition, RuntimeMemory rm) {
		this.showCondition = showCondition;
		this.rm = rm;
		this.question = question;
		CheckBoxListener checkboxListener = new CheckBoxListener();
		addItemListener((ItemListener) checkboxListener);
	}
	
	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == CheckBox.this) {
				if (CheckBox.this.isSelected()) {
					//If condition == true then show QUESTION
					rm.put(question.getId(), new BoolValue(isSelected()));
				} else {
					//If condition == true then show QUESTION
					rm.put(question.getId(), new BoolValue(isSelected()));
				}
			}
		}
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

	@Override
	public <T> T getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
