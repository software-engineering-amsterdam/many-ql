package cons.ql.ast.statement;

import java.util.Arrays;

import cons.ql.ast.Expression;
import cons.ql.ast.Statement;

public class If extends Statement {
	private final int EXPRESSION = 0;
	private final int BLOCK = 1;
	
	/**
	 * Constructor for the conditional block
	 * @param statement
	 */
	public If(Expression expression, Block block) {
		this.members.addAll(Arrays.asList(expression, block));
	}
	
	public Expression getExpression() {
		return (Expression) this.members.get(EXPRESSION);
	}
	
	public Block getBlock() {
		return (Block) this.members.get(BLOCK);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IfThen(");
		
		sb.append(getExpression().toString() + ", ");
		sb.append(getBlock().toString());
		sb.append(")");
		
		return sb.toString();
	}
}
