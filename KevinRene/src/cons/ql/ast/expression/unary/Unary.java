package cons.ql.ast.expression.unary;

import cons.ql.ast.expression.Expression;

public abstract class Unary extends Expression {
	
	protected Expression operand;
	protected String operator;
	
	public Unary(Expression operand, String operator) {
		this.operand = operand;
		this.operator = operator;
	}

	public String show() {
		return this.operator + this.operand.show();
	}
}
