package com.form.language.ast.statement;
import java.util.ArrayList;
import java.util.List;

public class Form {
	public String id;
	public List<Statement> statementList;
	
	public Form(String id) {
		this.id = id;
		this.statementList = new ArrayList<Statement>();
	}
	
	public Form(String id, List<Statement> statementList) {
		this.id = id;
		this.statementList = statementList;
	}
}
