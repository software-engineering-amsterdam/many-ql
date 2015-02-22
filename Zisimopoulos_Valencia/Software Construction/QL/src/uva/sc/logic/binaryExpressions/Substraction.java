package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Node;

public class Substraction extends BinaryExpression{

	public Substraction(Node firstOperand, Node secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op -]" + firstOperand + secondOperand;
	}

}
