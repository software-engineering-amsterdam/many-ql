package uva.sc.logic.unaryExpressions;

import uva.sc.logic.Expression;

public abstract class UnaryExpression extends Expression{
	
	Expression operand;
	
	public UnaryExpression (Expression operand){
		this.operand = operand;
	}

	public Expression getOperand() {
		return this.operand;
	}
}
