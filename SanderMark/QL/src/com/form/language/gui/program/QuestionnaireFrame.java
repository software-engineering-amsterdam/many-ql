package com.form.language.gui.program;

import javax.swing.JFrame;

import com.form.language.ast.form.Form;
import com.form.language.gui.components.FormComponent;
import com.form.language.memory.Context;

public class QuestionnaireFrame {

	private static final int weight = 500;
	private static final int height = 500;

	private JFrame frame;

	public QuestionnaireFrame(final Form form, Context context) {
		createFrame();		
		createFormComponent(form, context);
	}

	private void createFormComponent(final Form form, Context context) {
		FormComponent formComponent = new FormComponent(form, this.frame, context);
		formComponent.createGUIComponents();
	}

	private void createFrame() {
		this.frame = new JFrame();
		this.frame.setSize(weight, height);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
}
