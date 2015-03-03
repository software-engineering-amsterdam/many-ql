package ql.ast.statement;

import ql.ast.Expression;
import ql.ast.Statement;
import ql.ast.visitor.Visitor;

public class If extends Statement {
	private final Expression expression;
	private final Block block;
	
	/**
	 * Constructor for the conditional block
	 * @param statement
	 */
	public If(Expression expression, Block block) {
		this.expression = expression;
		this.block = block;
	}
	
	public Expression getExpression() {
		return this.expression;
	}
	
	public Block getBlock() {
		return this.block;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IfThen(");
		
		sb.append(getExpression().toString() + ", ");
		sb.append(getBlock().toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
