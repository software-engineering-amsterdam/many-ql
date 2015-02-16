package com.form.language.ast.statement;

import com.form.language.ast.values.GenericValue;

public class AssignmentStatement extends Statement {
	public String name;
	public GenericValue<?> value;
	
	public AssignmentStatement(String name, GenericValue<?> value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	
}
