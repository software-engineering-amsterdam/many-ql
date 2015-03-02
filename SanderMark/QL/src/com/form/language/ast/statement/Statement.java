package com.form.language.ast.statement;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;

public interface Statement {
		public JComponent createGUIComponent(JPanel panel);
		public Type getType();
		public abstract void getErrors(ErrorCollector errs);
}
