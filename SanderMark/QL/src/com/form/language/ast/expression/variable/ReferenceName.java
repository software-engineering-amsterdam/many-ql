package com.form.language.ast.expression.variable;

public class ReferenceName {
    private String name;

    public ReferenceName(String name)
    {
	this.name = name;		
    }

    public String getValue()
    {
	return name;
    }
}
