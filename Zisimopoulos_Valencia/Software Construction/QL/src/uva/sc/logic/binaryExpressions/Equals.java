package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Node;

public class Equals extends BinaryExpression{

	public Equals(Node firstOperand, Node secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op ==]";
	}
}
