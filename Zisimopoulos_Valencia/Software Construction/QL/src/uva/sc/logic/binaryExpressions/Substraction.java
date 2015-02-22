package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Node;

public class Substraction extends BinaryExpression{

	public Substraction(Node firstOperand, Node secondOperand) {
		super(firstOperand, secondOperand);
		System.out.print("op 1: " + firstOperand + " op 2: " + secondOperand);
	}
	
	public String toString() {
		return "[op -]" + firstOperand + secondOperand;
	}

}
