package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Node;

public class LesserThan extends BinaryExpression{

	public LesserThan(Node firstOperand, Node secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op <]";
	}

}
