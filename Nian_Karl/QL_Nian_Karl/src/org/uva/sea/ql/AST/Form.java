package org.uva.sea.ql.AST;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.AST.statement.Statement;

public class Form implements Node{
	private List<Statement> statementList;

	public Form() {
		this.statementList = new ArrayList<Statement>();
	}

	public void addStatement(QuestionStatement question) {
		this.statementList.add(question);
	}
	
	public Statement getStatement(int i) {
		if (i >= this.statementList.size()) {
			throw new IndexOutOfBoundsException("Index out of bound on " + i + " with size: " + this.statementList.size());
		}
		return this.statementList.get(i);
	}
	
	public List<Statement> getStatements() {
		return statementList;
	}

	@Override
	public void accept(Visitor visit) {
		visit.visit(this);
	}
}
