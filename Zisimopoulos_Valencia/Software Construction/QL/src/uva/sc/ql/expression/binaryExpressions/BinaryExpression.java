package uva.sc.ql.expression.binaryExpressions;

import uva.sc.core.types.Type;
import uva.sc.ql.expression.Expression;

public abstract class BinaryExpression extends Expression {

    Expression firstOperand;
    Expression secondOperand;
    Type type;

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
