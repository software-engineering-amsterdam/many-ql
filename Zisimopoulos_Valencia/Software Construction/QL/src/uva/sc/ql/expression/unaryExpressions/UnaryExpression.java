package uva.sc.ql.expression.unaryExpressions;

import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
public abstract class UnaryExpression extends Expression {

    Expression operand;

    public UnaryExpression(Expression operand) {
	this.operand = operand;
    }

    public Expression getOperand() {
	return this.operand;
    }
}
