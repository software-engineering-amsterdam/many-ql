package qls.ast.statement;

import java.util.ArrayList;
import java.util.List;

import qls.ast.Statement;
import qls.ast.visitor.StatementVisitor;

public class Block extends Statement {
	private List<Statement> statements;
	
	public Block() {
		statements = new ArrayList<Statement>();
	}
	
	/**
	 * Constructor for the statement case
	 * @param statement
	 */
	public Block(Statement statement) {
		statements = new ArrayList<Statement>();
		statements.add(statement);
	}
	
	public Block(Statement statement, Block statements) {
		this.statements = new ArrayList<Statement>();
		this.statements.add(statement);
		this.statements.addAll(statements.getStatements());
	}
	
	public List<Statement> getStatements() {
		return this.statements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Block(");
		
		for (Statement statement : statements) {
			sb.append(statement.toString() + ", ");
		}
		
		if (statements.size() > 0) {
			sb.setLength(sb.length() - 2);
		}
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}
