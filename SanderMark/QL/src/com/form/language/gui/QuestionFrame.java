package com.form.language.gui;

import javax.swing.JFrame;

import com.form.language.ast.Form;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;

public class QuestionFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int weight = 500;
    private static final int height = 500;

    public QuestionFrame(final Form form, Context context) {
	setSize(weight, height);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	GUIBuilder guiBuilder = new GUIBuilder(form, this, context);
	guiBuilder.createGUIForm();
	guiBuilder.createGUIComponents();

	setVisible(true);
    }

}
