package com.form.language.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.statement.Statement;
import com.form.language.memory.Context;

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

    public void getTypes(Context context) {
	for (Statement s : statementList) {
	    s.getType(context);
	}
    }

    public Iterator<Statement> iterator() {
	return statementList.iterator();
    }

    public Context initMemory(Context context) {
	for (Statement s : statementList) {
	    s.initMemory(context);
	}
	return context;
    }

    public void showTypes(Context context) {
	for (Statement s : statementList) {
	    System.out.println(s.getType(context));
	}
    }

}
