package cons.ql.ast.statement;

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
	
	public Block(Statement statement, Block statements) {
		this.statements.add(statement);
		this.statements.addAll(statements.statements());
	}
	
	public ArrayList<Statement> statements() {
		return this.statements;
	}

	@Override
	public String show() {
		return "Block";
	}
}
