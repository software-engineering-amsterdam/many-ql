package com.form.language.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.statement.Statement;
import com.form.language.memory.Context;

//TODO :: Seperate id and statementlist (just like within error)
public class Form {
    private String id;
    private List<Statement> statementList;

    public Form(String id) {
	this.id = id;
	this.statementList = new ArrayList<Statement>();
    }

    public Form(String id, List<Statement> statementList) {
	this.id = id;
	this.statementList = statementList;
    }

    public void getTypes(Context context) {
	for (Statement s : statementList) {
	    s.checkType(context);
	}
    }

    public Context initMemory(Context context) {
	for (Statement s : statementList) {
	    s.initMemory(context);
	}
	return context;
    }
    
    public List<Statement> getStatements(){
	return this.statementList;
    }

    public String getId() {
        return id;
    }

}
