package com.form.language.ast.statement;

import com.form.language.ast.expression.PrimitiveExpression;

public class AssignmentStatement extends Statement {
	public String name;
	public PrimitiveExpression expression;
	
	public AssignmentStatement(String name, PrimitiveExpression expression) {
		super();
		this.name = name;
		this.expression = expression;
	}
	
	
}
