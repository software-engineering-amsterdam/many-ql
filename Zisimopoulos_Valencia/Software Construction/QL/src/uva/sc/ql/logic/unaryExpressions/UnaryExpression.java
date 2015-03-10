package uva.sc.ql.logic.unaryExpressions;

import uva.sc.ql.logic.Expression;

public abstract class UnaryExpression extends Expression {

	Expression	operand;

	public UnaryExpression(Expression operand) {
		this.operand = operand;
	}

	public Expression getOperand() {
		return this.operand;
	}
}
