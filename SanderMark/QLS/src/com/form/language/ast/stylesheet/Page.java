package com.form.language.ast.stylesheet;

import java.util.List;

import com.form.language.ast.stylesheet.Statement.Statement;

public class Page  {

	protected final String name;
	protected final List<Statement> statements;
	
	public Page(String name, List<Statement> statements) {
        this.name = name;
        this.statements = statements;
    }
	
	public String getName() {
        return this.name;
    }

    public List<Statement> getSections() {
        return this.statements;
    }

}
