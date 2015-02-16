package com.form.language.ast.statement;

import java.util.List;

import com.form.language.ast.expression.PrimitiveExpression;

public class IfStatement extends Statement {
	public PrimitiveExpression conditions;
	public List<Statement> thenStatements;
	
	
	public IfStatement(PrimitiveExpression conditions, List<Statement> thenStatements) {
		super();
		this.conditions = conditions;
		this.thenStatements = thenStatements;
	}
	
}