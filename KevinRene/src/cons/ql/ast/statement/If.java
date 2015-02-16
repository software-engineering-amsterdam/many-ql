package cons.ql.ast.statement;

import cons.ql.ast.Expression;
import cons.ql.ast.Statement;
import cons.ql.ast.visitor.Visitor;

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
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
