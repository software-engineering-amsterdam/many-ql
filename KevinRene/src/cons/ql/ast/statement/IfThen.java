package cons.ql.ast.statement;

import cons.ql.ast.Expression;
import cons.ql.ast.Statement;
import cons.ql.ast.Visitor;

public class IfThen extends Statement {
	private Expression expression;
	private Statement statements;
	
	/**
	 * Constructor for the conditional block
	 * @param statement
	 */
	public IfThen(Expression expression, Statement statements) {
		this.expression = expression;
		this.statements = statements;
	}
	
	public Statement statements() {
		return this.statements;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IfThen(");
		
		sb.append(expression.toString() + ", ");
		sb.append(statements.toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub		
	}
}
