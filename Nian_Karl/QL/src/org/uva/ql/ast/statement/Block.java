package org.uva.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.visitor.Visitor;

public class Block extends Statement {

	private List<Statement> statements;

	public Block() {
		statements = new ArrayList<Statement>();
	}

	public void addStatement(Statement statement) {
		statements.add(statement);
	}
	
	public List<Statement> getStatements() {
		return statements;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
