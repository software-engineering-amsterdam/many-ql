package com.form.language.ast.statement;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;

public class AssignmentStatement implements Statement {
	public String name;
	public Expression expression;
	
	public AssignmentStatement(String name, Expression expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	@Override
	public JComponent createGUIComponent(JPanel panel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType() {
		return expression.getType();
	}

	@Override
	public void getErrors(ErrorCollector errs) {
		return;
	}
	
	
}
