package com.form.language.ast.form;

import java.util.ArrayList;
import java.util.List;

import com.form.language.ast.statement.Statement;
import com.form.language.memory.Context;

public class FormStatementCollection {
    private List<Statement> statementList;

    public FormStatementCollection()
    {
	this.statementList =  new ArrayList<Statement>();
    }

    public FormStatementCollection(List<Statement> statementList)
    {
	this.statementList = statementList;
    }

    public void checkTypes(Context context) {
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

    public List<Statement> getValue() 
    {
	return statementList;
    }
}
