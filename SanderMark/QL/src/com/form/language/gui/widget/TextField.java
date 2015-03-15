package com.form.language.gui.widget;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public class TextField extends JTextField {

	private static final long serialVersionUID = 1L;    
	private Context context;
	private Question question;

	public TextField(Question question, QuestionComponent questionComponent, Context context) {
		this.context = context;
		this.question = question;
		this.setMaximumSize(new Dimension(200, 20));
		TextFieldListener textfieldListener = new TextFieldListener();
		this.getDocument().addDocumentListener(textfieldListener);
	}

	// TODO ADD HANDELER
	private class TextFieldListener implements DocumentListener {
		public void actionPerformed(DocumentEvent e) {
			context.setValue(question.getId(), new IntValue(Integer.parseInt(TextField.this.getText())));
			checkDependencyVisibility();
		}

		private void checkDependencyVisibility() {
			Iterator<Expression> iterator = context.getReferencingExpressions(question.getId());
			while (iterator.hasNext()) {
				Expression exp = iterator.next();
				List<QuestionComponent> q = context.getDependantQuestions(exp);
				checkVisibilities(exp, q);
			}
		}

		private void checkVisibilities(Expression exp, List<QuestionComponent> q) {
			for (QuestionComponent question : q) {
				question.checkVisibility(((BoolValue) exp.evaluate(context)).getValue());
			}
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
