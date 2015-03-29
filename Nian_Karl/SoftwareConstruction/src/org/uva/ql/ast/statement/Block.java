package org.uva.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.visitor.StatementVisitor;

public class Block extends Statement {

	private List<Statement> statements;

	public Block(CodePosition pos) {
		super(pos);
		statements = new ArrayList<Statement>();
	}

	public void addStatement(Statement statement) {
		statements.add(statement);
	}

	public List<Statement> getStatements() {
		return statements;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
