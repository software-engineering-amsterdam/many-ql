package com.form.language.ast.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.statement.Statement;
import com.form.language.memory.Context;

//TODO :: Seperate id and statementlist (just like within error)
public class Form {
    private FormId id;
    private FormStatementCollection statementList;

    public Form(String id) {
	this.id = new FormId(id);
	this.statementList = new FormStatementCollection();
    }

    public Form(String id, List<Statement> statementList) {
    this.id = new FormId(id);
	this.statementList = new FormStatementCollection(statementList);
    }

    public void getTypes(Context context) {
    	statementList.getTypes(context);
    }

    public Context initMemory(Context context) {
    	return statementList.initMemory(context);
    }
    
    public List<Statement> getStatements(){
    	return statementList.getValue();
    }

    public String getId() {
        return id.getValue();
    }

}
