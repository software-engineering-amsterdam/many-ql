package com.form.language.gui.components;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.statement.Question;
import com.form.language.ast.statement.Statement;

public class GUIComponent extends JComponent {
	public static QuestionComponent createGUIComponent(GUIForm guiform, Statement statement) {
		return new QuestionComponent((Question)statement);		
	}
}
