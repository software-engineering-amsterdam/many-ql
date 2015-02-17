package com.form.language.ast.statement;

import javax.swing.JComponent;

import com.form.language.ast.expression.PrimitiveExpression;

public class AssignmentStatement implements Statement {
	public String name;
	public PrimitiveExpression expression;
	
	public AssignmentStatement(String name, PrimitiveExpression expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	@Override
	public JComponent createGUIComponent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
