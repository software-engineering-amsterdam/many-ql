package ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import ql.ast.Statement;
import ql.ast.visitor.StatementVisitor;

public class Block extends Statement {
	
	private List<Statement> statements = new ArrayList<Statement>();
	
	public Block() {}
	
	/**
	 * Constructor for the statement case
	 * @param statement
	 */
	public Block(Statement statement) {
		this.statements.add(statement);
	}
	
	public Block(Statement statement, Block statements) {
		this.statements.add(statement);
		this.statements.addAll(statements.getStatements());
	}
	
	public List<Statement> getStatements() {
		return this.statements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Block(");
		
		for(Statement statement : statements) {
			sb.append(statement.toString() + ", ");
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}