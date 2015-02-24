package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Node;

public class GreaterThanEquals extends BinaryExpression{

	public GreaterThanEquals(Node firstOperand, Node secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op >=]";
	}

}
