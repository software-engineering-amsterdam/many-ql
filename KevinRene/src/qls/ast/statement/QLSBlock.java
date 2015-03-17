package qls.ast.statement;

import java.util.ArrayList;
import java.util.List;

import qls.ast.QLSStatement;
import qls.ast.visitor.StatementVisitor;

public class QLSBlock extends QLSStatement {
	private List<QLSStatement> statements;
	
	public QLSBlock() {
		statements = new ArrayList<QLSStatement>();
	}
	
	/**
	 * Constructor for the statement case
	 * @param statement
	 */
	public QLSBlock(QLSStatement statement) {
		statements = new ArrayList<QLSStatement>();
		statements.add(statement);
	}
	
	public QLSBlock(QLSStatement statement, QLSBlock statements) {
		this.statements = new ArrayList<QLSStatement>();
		this.statements.add(statement);
		this.statements.addAll(statements.getStatements());
	}
	
	public List<QLSStatement> getStatements() {
		return this.statements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Block(");
		
		for (QLSStatement statement : statements) {
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
