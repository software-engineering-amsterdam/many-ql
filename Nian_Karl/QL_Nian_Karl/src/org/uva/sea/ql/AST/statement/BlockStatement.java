package org.uva.sea.ql.AST.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.visitor.Visitor;

public class BlockStatement extends Statement {

	private List<Statement> statementList;

	public BlockStatement() {
		statementList = new ArrayList<Statement>();
	}

	public void addStatement(Statement statement) {
		statementList.add(statement);
	}
	
	public List<Statement> getStatementList() {
		return statementList;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void visitChilds(Visitor visitor) {
		for (Statement statement : statementList) {
			statement.accept(visitor);
		}
	}
}
