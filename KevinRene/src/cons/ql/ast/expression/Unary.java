package cons.ql.ast.expression;

import cons.ql.ast.Expression;
import cons.ql.ast.visitor.Visitor;

public abstract class Unary extends Expression {
	protected Expression operand;
	protected String operator;
	
	public Unary(Expression operand, String operator) {
		this.operand = operand;
		this.operator = operator;
	}

	@Override
	public String toString() {
		return this.operator + this.operand.toString();
	}
}
