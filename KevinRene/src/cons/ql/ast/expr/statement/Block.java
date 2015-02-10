package cons.ql.ast.expr.statement;

import java.util.ArrayList;

public class Block extends Statement {

	private ArrayList<Statement> statements = new ArrayList<Statement>();
	
	/**
	 * Constructor for the statement case
	 * @param statement
	 */
	public Block(Statement statement) {
		this.statements.add(statement);
	}
	
	public Block(Block statements, Statement statement) {
		this.statements.add(statement);
		this.statements.addAll(statements.statements());
	}
	
	public ArrayList<Statement> statements() {
		return this.statements;
	}
}
