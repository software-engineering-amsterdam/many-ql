package uva.sc.ql.expression.binaryExpressions;

import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
public abstract class BinaryExpression extends Expression {

    private Expression firstOperand;
    private Expression secondOperand;

    public BinaryExpression(Expression firstOperand, Expression secondOperand) {
	this.firstOperand = firstOperand;
	this.secondOperand = secondOperand;
    }

    public Expression getFirstOperand() {
	return firstOperand;
    }

    public Expression getSecondOperand() {
	return secondOperand;
    }

}
