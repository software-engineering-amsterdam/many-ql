package com.form.language.ast.stylesheet.Statement;

import java.util.List;

public class Section implements Statement {
	
	private String name;
	private List<Statement> statements;
	
    public Section(String name, List<Statement> statements) {
    	this.name = name;
        this.statements = statements;
    }

	public void getType() {
		// TODO Auto-generated method stub
		
	}

	public void createGUIComponent() {
		// TODO Auto-generated method stub
		
	}

	public void initMemory() {
		// TODO Auto-generated method stub
		
	}

}
