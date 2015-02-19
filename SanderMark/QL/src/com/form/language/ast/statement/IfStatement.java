package com.form.language.ast.statement;

import java.util.List;

import javax.swing.JComponent;

import com.form.language.ast.expression.PrimitiveExpression;

public class IfStatement implements Statement {
	public PrimitiveExpression conditions;
	public List<Statement> thenStatements;
	
	
	public IfStatement(PrimitiveExpression conditions, List<Statement> thenStatements) {
		super();
		this.conditions = conditions;
		this.thenStatements = thenStatements;
	}


	@Override
	public JComponent createGUIComponent() {
		// TODO Auto-generated method stub
		return null;
	}
	
}