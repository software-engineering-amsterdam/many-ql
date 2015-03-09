package com.form.language.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.RuntimeMemory;

public class CheckBox extends JCheckBox {
	private static final long serialVersionUID = 1L;
	private QuestionComponent questionComponent;
	private RuntimeMemory rm;
	private Question question;
	
	public CheckBox(Question question, QuestionComponent questionComponent, RuntimeMemory rm) {
		this.rm = rm;
		this.question = question;
		this.questionComponent = questionComponent;
		CheckBoxListener checkboxListener = new CheckBoxListener();
		addItemListener((ItemListener) checkboxListener);
	}
	
	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == CheckBox.this) {
				
				//Update zijn value / question id in de memory
				rm.put(question.getId(), new BoolValue(CheckBox.this.isSelected()));

				//Check alle conditions in the memory
				for(Expression exp : rm.getExpressions())
				{
					//Van deze condition evaluate zijn expression 
					QuestionComponent q = rm.getQcomponent(exp);
					
					//Zet de question binnen if op true of false qua visibility
					q.checkVisibility(((BoolValue)exp.evaluate(rm)).getValue());
				}
			}
		}
	}
}
