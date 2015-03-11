package com.form.language.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class CheckBox extends JCheckBox {
	private static final long serialVersionUID = 1L;
	private Context context;
	private Question question;
	
	public CheckBox(Question question, QuestionComponent questionComponent, Context context) {
		this.context = context;
		this.question = question;
		CheckBoxListener checkboxListener = new CheckBoxListener();
		addItemListener((ItemListener) checkboxListener);
	}
	
	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == CheckBox.this) {
				context.setValue(question.getId(), new BoolValue(CheckBox.this.isSelected()));
				checkDependencyVisibility();
			}
		}

		private void checkDependencyVisibility() {			
			Iterator<Expression> iterator = context.getReferencingExpressions(question.getId());			
			while(iterator.hasNext())
			{
				Expression exp = iterator.next();
				List<QuestionComponent> q = context.getDependantQuestions(exp);					
				checkVisibilities(exp, q);
			}
		}

		private void checkVisibilities(Expression exp, List<QuestionComponent> q) {
			for(QuestionComponent question : q)
			{
				question.checkVisibility(((BoolValue)exp.evaluate(context)).getValue());
			}
		}
	}
}
