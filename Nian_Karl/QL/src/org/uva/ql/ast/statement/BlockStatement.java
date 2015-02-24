package org.uva.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.visitor.Visitor;

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

	public void visitChilds(Visitor visitor) {
		for (Statement statement : statementList) {
			statement.accept(visitor);
		}
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
