package com.form.language.ast.statement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatementCollection implements Iterable<Statement> {
    private List<Statement> statements;
    
    public StatementCollection(){
	this.statements = new ArrayList<Statement>();
    }
    
    public StatementCollection(List<Statement> statements){
	this.statements = statements;
    }

    @Override
    public Iterator<Statement> iterator() {
	return statements.iterator();
    }
}
