package uva.sc.ql.logic.binaryExpressions;

import uva.sc.ql.logic.Expression;
import uva.sc.ql.types.Type;

public abstract class BinaryExpression extends Expression {

	Expression	firstOperand;
	Expression	secondOperand;
	Type		type;

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
