package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Expression;
import uva.sc.types.Type;

public abstract class BinaryExpression extends Expression{
	
	Expression firstOperand;
	Expression secondOperand;
	Type type;
	
	
	public BinaryExpression (Expression firstOperand, Expression secondOperand){
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
