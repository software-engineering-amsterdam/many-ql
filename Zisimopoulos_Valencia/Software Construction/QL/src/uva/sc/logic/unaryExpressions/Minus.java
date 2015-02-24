package uva.sc.logic.unaryExpressions;

import uva.sc.logic.Node;

public class Minus extends UnaryExpression{

	public Minus(Node operand) {
		super(operand);
	}
	
	public String toString() {
		return "[un -]";
	}

}
