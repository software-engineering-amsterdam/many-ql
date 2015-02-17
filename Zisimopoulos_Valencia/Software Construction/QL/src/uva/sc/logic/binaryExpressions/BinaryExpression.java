package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Expression;
import uva.sc.logic.Node;

public abstract class BinaryExpression extends Expression{
	Node firstOperand;
	Node secondOperand;
	
	public BinaryExpression (Node firstOperand, Node secondOperand){
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}
}
