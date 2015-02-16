package cons.ql.ast.statement;

import java.util.ArrayList;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Statement;

public class Block extends Statement {	
	/**
	 * Constructor for the statement case
	 * @param statement
	 */
	public Block(Statement statement) {
		this.members.add(statement);
	}
	
	public Block(Statement statement, Block statements) {
		this.members.add(statement);
		this.members.addAll(statements.statements());
	}
	
	public ArrayList<ASTNode> statements() {
		return this.members;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Block(");
		
		for(ASTNode member : members) {
			sb.append(member.toString() + ", ");
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(")");
		
		return sb.toString();
	}
}
